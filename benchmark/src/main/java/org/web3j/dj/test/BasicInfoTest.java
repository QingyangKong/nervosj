package org.web3j.dj.test;

import org.web3j.crypto.Credentials;
import org.web3j.dj.Basic_info;
import org.web3j.dj.Basic_info_op;
import org.web3j.dj.DjUtils;
import org.web3j.dj.Meeting_op;
import org.web3j.protobuf.ConvertStrByte;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.EthLog;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple10;
import org.web3j.tx.CitaTransactionManager;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class BasicInfoTest {

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

    public BasicInfoTest() throws Exception {
        HttpService.setDebug(false);
        this.service = Web3j.build(new HttpService("http://localhost:1337"));
        this.creator = Credentials.create(privateKey);
        transactionManager = new CitaTransactionManager(service, creator, 5, 3000);
        quota = BigInteger.valueOf(999999999);
        nonce = BigInteger.valueOf(Math.abs(this.random.nextLong()));
        currentHeight = this.service.ethBlockNumber().send().getBlockNumber();
    }

    public static void main(String args[]) throws Exception {

        BasicInfoTest basicInfoTest = new BasicInfoTest();
        String basicInfoOpAddress = "0xe5f4cf53160b5c168408f176c2fb19be98570933";
        basicInfoTest.upload(basicInfoOpAddress);
        Thread.sleep(8000);

        String basicInfoAddress = "0x1e7e18d0d17e03cdb171e1ffb1e5c90918a5f352";
        basicInfoTest.query(basicInfoAddress);
    }


    public void upload(String contractAddress) {

        System.out.println("----------------start upload test-----------------------------");
        byte[] _memId = DjUtils.stringToByteArray("jdoaifjodis");
        String _memberAddress = "0x6e6545d62e3d55b3fa16884695300ab2b2498869";
        byte[] _name = DjUtils.stringToByteArray("da s");
        byte[] _gender = DjUtils.stringToByteArray("men");
        byte[] _nation = DjUtils.stringToByteArray("china");
        byte[] _birthday = DjUtils.stringToByteArray("0308");
        byte[] _political = DjUtils.stringToByteArray("no");
        byte[] _merrage = DjUtils.stringToByteArray("no");

        List<byte[]> _extraInfo = new ArrayList<>();
        _extraInfo.add(DjUtils.stringToByteArray("extra1"));
        _extraInfo.add(DjUtils.stringToByteArray("extra2"));
        _extraInfo.add(DjUtils.stringToByteArray("extra3"));
        _extraInfo.add(DjUtils.stringToByteArray("extra4"));
        _extraInfo.add(DjUtils.stringToByteArray("extra5"));

        String operateDate = "0523";
        String operateTime = "14:00";
        String operator = "wang";
        String desc = "important";
        List<byte[]> _opInfo = new ArrayList<>();
        byte[] _operateDate = DjUtils.stringToByteArray(operateDate);
        byte[] _operateTime = DjUtils.stringToByteArray(operateTime);
        byte[] _operator = DjUtils.stringToByteArray(operator);
        byte[] _desc = DjUtils.stringToByteArray(desc);
        _opInfo.add(_operateDate);
        _opInfo.add(_operateTime);
        _opInfo.add(_operator);
        _opInfo.add(_desc);

        String _origin = "zhanghang";
        String _homeAddress = "zhanghang";
        String _committee = "0x0dbd369a741319fa5107733e2c9db9929093e3c7";

        Basic_info_op basic_info_op = Basic_info_op.load(contractAddress, this.service, transactionManager);
        try {
            System.out.println("basic_info_op = " + basic_info_op.isValid());
            CompletableFuture<TransactionReceipt> future = basic_info_op.uploadMemBasicInfo(_memId, _memberAddress, _name, _gender, _nation, _birthday, _political, _merrage,
                    _extraInfo, _opInfo, _homeAddress, _origin, this.quota, this.nonce, this.currentHeight.add(this.offset), BigInteger.valueOf(version)).sendAsync();
            TransactionReceipt transactionReceipt = future.get(12, TimeUnit.SECONDS);

            if (transactionReceipt.getErrorMessage() == null) {
                System.out.println(" execute uploadMeeting success");

            } else {
                System.out.println(" execute uploadMeeting failed, " + transactionReceipt.getErrorMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("----------------end upload test-----------------------------");

    }

    public void query(String contractAddress) {
        System.out.println("----------------start query test-----------------------------");

        Basic_info basic_info = Basic_info.load(contractAddress, this.service, transactionManager);
        try {
            System.out.println("basic_info = " + basic_info.isValid());
            String memberAddress = "0x6e6545d62e3d55b3fa16884695300ab2b2498869";
            Tuple10<byte[], byte[], byte[], byte[], byte[], byte[], byte[], List<byte[]>, String, String> tuple10 = basic_info.query(memberAddress).send();
            System.out.println(tuple10.toString());
            System.out.println("value1= " + new String(tuple10.getValue1()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("----------------end uploadMeeting test-----------------------------");
    }

}
