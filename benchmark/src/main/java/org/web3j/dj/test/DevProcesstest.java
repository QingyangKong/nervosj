package org.web3j.dj.test;

import org.web3j.crypto.Credentials;
import org.web3j.dj.Dev_process_op;
import org.web3j.dj.DjUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.EthLog;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.CitaTransactionManager;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class DevProcesstest {
    private static final String privateKey = "0x2c5c6c187d42e58a4c212a4aab0a3cfa4030256ed82bb3e05706706ab5be9641";
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

    public DevProcesstest() throws Exception {
        HttpService.setDebug(true);
        this.service = Web3j.build(new HttpService("http://localhost:1337"));
        this.creator = Credentials.create(privateKey);
        System.out.println(this.creator.getAddress());
        transactionManager = new CitaTransactionManager(service, creator, 5, 3000);
        quota = BigInteger.valueOf(999999999);
        nonce = BigInteger.valueOf(Math.abs(this.random.nextLong()));
        currentHeight = this.service.ethBlockNumber().send().getBlockNumber();
    }

    public static void main(String args[]) throws Exception {
        String devProcessAddress = "0x851d4ad4bc524a12812493fa9f004eb6f5fffab8";
        DevProcesstest registerTest = new DevProcesstest();
        registerTest.applyForParty(devProcessAddress);
    }


    public void applyForParty(String contractAddress) {
        System.out.println("---------------------Now, start applyForParty test-----------------------------");

        List<byte[]> _orgName = new ArrayList<>(128);
        byte[] b1_org = utils.stringToByteArray("zhongguo");
        byte[] b2_org = utils.stringToByteArray("yinhang");
        _orgName.add(b1_org);
        _orgName.add(b2_org);

        byte[] _memId = utils.stringToByteArray("033e2c9db9929093e3c7");
        byte[] _memProfileId = utils.stringToByteArray("memProfileId");
        byte[] _operateDate = utils.stringToByteArray("20180421");
        byte[] _operateTime = utils.stringToByteArray("1106");
        byte[] _fileHash = utils.stringToByteArray("fileHash");

        List<byte[]> _institution = new ArrayList<>(128);
        byte[] b1_institution = utils.stringToByteArray("zhongguo");
        byte[] b2_institution = utils.stringToByteArray("yinhang");
        _institution.add(b1_institution);
        _institution.add(b2_institution);

        byte[] _desc = utils.stringToByteArray("介绍");
        ;
        String _committee = "0x0dbd369a741319fa5107733e2c9db9929093e3c7";

        Dev_process_op devProcessOp = Dev_process_op.load(contractAddress, this.service, transactionManager);
        TransactionReceipt receipt;
        try {
            System.out.println("devProcessOp.isValid() = " + devProcessOp.isValid());

            CompletableFuture<TransactionReceipt> future = devProcessOp.applyForParty(_orgName, _memId, _memProfileId, _operateDate, _operateTime,
                    _fileHash, _institution, _desc, _committee, this.quota, this.nonce, this.currentHeight.add(this.offset), BigInteger.valueOf(version)).sendAsync();
            Thread.sleep(6000);
            receipt = future.get(12, TimeUnit.SECONDS);
            if (receipt.getErrorMessage() == null) {
                System.out.println(" execute applyForParty success");
            } else {
                System.out.println(" execute applyForParty failed, " + receipt.getErrorMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
