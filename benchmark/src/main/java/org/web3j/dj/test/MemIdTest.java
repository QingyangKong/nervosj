package org.web3j.dj.test;

import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.dj.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.CitaTransactionManager;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;

public class MemIdTest {
    private static final String privateKey = "352416e1c910e413768c51390dfd791b414212b7b4fe6b1a18f58007fa894214";
    private static BigInteger quota;
    private final static int version = 0;
    private final BigInteger offset = BigInteger.valueOf(80);
    private final Random random = new Random(System.currentTimeMillis());
    private Credentials creator;
    private static Web3j service;
    private BigInteger nonce;
    private BigInteger currentHeight;
    private static CitaTransactionManager transactionManager;
    private DjUtils utils;

    public MemIdTest() throws Exception {
        HttpService.setDebug(false);
        this.service = Web3j.build(new HttpService("http://localhost:1337"));
        this.creator = Credentials.create(privateKey);
        transactionManager = new CitaTransactionManager(service, creator, 5, 3000);
        quota = BigInteger.valueOf(999999999);
        nonce = BigInteger.valueOf(Math.abs(this.random.nextLong()));
        currentHeight = this.service.ethBlockNumber().send().getBlockNumber();
        utils = new DjUtils();
    }

    public static void main(String args[]) throws Exception {

        String memIdAddress = "0xb28fb2d6128da50afdb086e657cbf6ecc6667671";
        String mem = "0xb28fb2d6128da";
        String id = "123456";

        MemIdTest memIdTest = new MemIdTest();
        System.out.println("before memId... " + memIdTest.isMem(mem));
        memIdTest.addId(memIdAddress, mem, id);
        System.out.println("after memId... " + memIdTest.isMem(mem));
        memIdTest.queryUsers();
    }


    public void addId(String contractAddress, String mem, String id) {
        System.out.println("---------------------start addId test-----------------------------");

        try {
            Mem_id_op mem_id_op = Mem_id_op.load(contractAddress, service, transactionManager);
            System.out.println("mem_id_op.isvalid() = " + mem_id_op.isValid());
            byte[] _id = utils.stringToByteArray(id);

            mem_id_op.addId(mem, _id, this.quota, this.nonce, this.currentHeight.add(this.offset), BigInteger.valueOf(version)).send();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("---------------------end addId test-----------------------------\n");
    }

    public boolean isMem(String _mem) {
        System.out.println("---------------------start isMem test-----------------------------");

        boolean status = false;
        try {
            String registerAddress = "0x38a6a377835ebd9446ec38051b16370cd1ea6626";
            Register register = Register.load(registerAddress, service, transactionManager);
            String _committee = "0x0dbd369a741319fa5107733e2c9db9929093e3c7";
            String idAddr = register.memIdAddr(_committee).send();
            Party_mem_id party_mem_id = Party_mem_id.load(idAddr, service, transactionManager);
            System.out.println("party_mem_id.isvalid()..." + party_mem_id.isValid());
            status = party_mem_id.isMem(_mem).send();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("---------------------end isMem test-----------------------------\n");
        return status;
    }

    public boolean queryUsers() {
        System.out.println("---------------------start queryUsers test-----------------------------");

        boolean status = false;
        try {
            String registerAddress = "0x38a6a377835ebd9446ec38051b16370cd1ea6626";
            Register register = Register.load(registerAddress, service, transactionManager);
            String _committee = "0x0dbd369a741319fa5107733e2c9db9929093e3c7";
            String idAddr = register.memIdAddr(_committee).send();
            Party_mem_id party_mem_id = Party_mem_id.load(idAddr, service, transactionManager);
            System.out.println("party_mem_id.isvalid()..." + party_mem_id.isValid());

            List<Bytes32> l = party_mem_id.queryUsers().send();
            for (int i = 0; i < l.size(); ++i) {
                System.out.println(new String(l.get(i).getValue()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("---------------------end queryUsers test-----------------------------\n");
        return status;
    }


}
