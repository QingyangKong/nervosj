package org.web3j.dj;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.omg.CORBA.BAD_CONTEXT;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.CitaTransactionManager;
import org.web3j.utils.Numeric;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RegisterTest {

    private static final String privateKey = "5f0258a4778057a8a7d97809bd209055b2fbafa654ce7d31ec7191066b9225e6";
    private static BigInteger quota;
    private final static int version = 0;
    private final static int chainId = 530509907;
    private final BigInteger offset = BigInteger.valueOf(80);
    private final Random random = new Random(System.currentTimeMillis());
    private final Credentials creator;
    private Web3j service;
    private Register register;
    private BigInteger nonce;
    private BigInteger currentHeight;
    private CitaTransactionManager transactionManager;

    public RegisterTest() throws Exception {
        this.service = Web3j.build(new HttpService("http://120.27.213.202:1337"));
        this.creator = Credentials.create(privateKey);
        this.transactionManager = new CitaTransactionManager(service, creator, 5, 3000);
        quota = BigInteger.valueOf(1000000000);
        nonce = BigInteger.valueOf(Math.abs(this.random.nextLong()));
        currentHeight = this.service.ethBlockNumber().send().getBlockNumber();
    }

    public static void main(String args[]) throws Exception {

        RegisterTest registerTest = new RegisterTest();
        registerTest.deployContract();
        registerTest.newOrg();
    }

    //部署合约
    public void deployContract() {
        System.out.println("-------------------------------Now, start test:----------------------------------");
        System.out.println("Creator's address:" + creator.getAddress());

        try {
            register = Register.deploy(service, transactionManager, quota,
                    this.nonce, this.currentHeight.add(this.offset), BigInteger.valueOf(version),
                    BigInteger.valueOf(chainId), creator.getAddress()).send();

            System.out.println("--------------------------deploy success, contract address:" + this.register.getContractAddress());
        } catch (Exception e) {
            System.out.println("-----------------------------deploy contract failed because of " + e);
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("orgInfoOpAddr: " + this.getOrgInfoOpAddr());
        System.out.println("basicInfoOpAddr: " + this.getBasicInfoOpAddr());
        System.out.println("devProcessOpAddr: " + this.getDevProcessOpAddr());
        System.out.println("memIdAddr: " + this.getMemIdOpAddr());
        System.out.println("meetingOpAddr: " + this.getMeetingOpAddr());
    }

    //新建党组织机构操作
    public void newOrg() {
        System.out.println("---------------------Now, start newOrg test-----------------------------");
        String committee = "0x4b5ae4567ad5d9fb92bc9afd6a657e6fa13a2523";
        String org = "zhaohang";
        byte[] org32;
        org32 = Numeric.hexStringToByteArray(asciiToHex(org));
        List<String> members = new ArrayList<String>();
        members.add("0x0dbd369a741319fa5107733e2c9db9929093e3c7");
        members.add("0x0dbd369a741319fa5107733e2c9db9929093e3c7");
        List<byte[]> ids = new ArrayList<>();
        String b1 = "123";
        String b2 = "456";
        byte[] b1_32 = Numeric.hexStringToByteArray(asciiToHex(b1));
        byte[] b2_32 = Numeric.hexStringToByteArray(asciiToHex(b2));
        ids.add(b1_32);
        ids.add(b2_32);

        Register reg = Register.load(creator.getAddress(), this.service, transactionManager);
        TransactionReceipt receipt;
        try {
            CompletableFuture<TransactionReceipt> future = reg.newOrg(committee, org32, members, ids,
                    this.quota, this.nonce, this.currentHeight.add(this.offset), BigInteger.valueOf(version), BigInteger.valueOf(chainId)).sendAsync();
            receipt = future.get(12, TimeUnit.SECONDS);
            if (receipt.getErrorMessage() == null) {
                System.out.println(" execute success");
            } else {
                System.out.println("receipt.getErrorMessage()................." + receipt.getErrorMessage());
                System.out.println(" execute failed, " + receipt.getErrorMessage());
            }
            getEthLOg(DefaultBlockParameter.valueOf(BigInteger.ONE), DefaultBlockParameter.valueOf("latest"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取日志
    public void getEthLOg(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        try {
            //Register reg = Register.load(this.creator.getAddress(), this.service, transactionManager);

            //构建filter,添加topics
            EthFilter filter = new EthFilter(startBlock, endBlock, this.register.getContractAddress());
            filter.addSingleTopic("0x8faf579e9bca92f0fe319e324c630f8b94b86e283bf4f9ba1e3e0e880b5c52e0");
            //filter.addSingleTopic("0x0000000000000000000000006c6930d9f8d2033b85807148fc68b96dbfa38d3c");

            List<EthLog.LogResult> logs = this.service.ethGetLogs(filter).send().getLogs();
            System.out.println("logs.size()............." + logs.size());
            for (int i = 0; i < logs.size(); i++) {
                EthLog.LogResult<EthLog.LogObject> result = logs.get(i);
                Log log = result.get();
                List<String> strs = log.getTopics();

                System.out.println("strs.size()..............." + strs.size());
                for (int y = 0; y < strs.size(); y++) {
                    System.out.println(strs.get(y));
                }
            }
        } catch (Throwable e) {
            System.out.println("get log" + "failed because of " + e);
        }
    }

    public String getOrgInfoOpAddr() {
        String orgInfoOpAddr = null;
        try {
            orgInfoOpAddr = this.register.orgInfoOpAddr().send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orgInfoOpAddr;
    }

    public String getBasicInfoOpAddr() {
        String basicInfoOpAddr = null;
        try {
            basicInfoOpAddr = this.register.basicInfoOpAddr().send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return basicInfoOpAddr;
    }

    public String getDevProcessOpAddr() {
        String devProcessOpAddr = null;
        try {
            devProcessOpAddr = this.register.devProcessOpAddr().send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return devProcessOpAddr;
    }

    public String getMemIdOpAddr() {
        String memIdAddr = null;
        try {
            memIdAddr = this.register.memIdOpAddr().send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return memIdAddr;
    }

    public String getMeetingOpAddr() {
        String meetingOpAddr = null;
        try {
            meetingOpAddr = this.register.meetingOpAddr().send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return meetingOpAddr;
    }

    // String to 64 length HexString (equivalent to 32 Hex lenght)
    //byte[] myStringInByte = Numeric.hexStringToByteArray(asciiToHex("myString"));
    public static String asciiToHex(String asciiValue) {
        char[] chars = asciiValue.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }
        return hex.toString() + "".join("", Collections.nCopies(32 - (hex.length() / 2), "00"));
    }

}
