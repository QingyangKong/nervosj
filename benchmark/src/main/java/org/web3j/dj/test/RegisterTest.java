package org.web3j.dj.test;

import org.web3j.crypto.Credentials;
import org.web3j.dj.DjUtils;
import org.web3j.dj.Register;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.CitaTransactionManager;
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;

public class RegisterTest {

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

    public RegisterTest() throws Exception {
        HttpService.setDebug(false);
        this.service = Web3j.build(new HttpService("http://localhost:1337"));
        this.creator = Credentials.create(privateKey);
        transactionManager = new CitaTransactionManager(service, creator, 5, 3000);
        quota = BigInteger.valueOf(999999999);
        nonce = BigInteger.valueOf(Math.abs(this.random.nextLong()));
        currentHeight = this.service.ethBlockNumber().send().getBlockNumber();
    }

    public static void main(String args[]) throws Exception {
        String registerAddress = "0x61d76f1416b1d1bbd5778d1fa17377731d81eaa2";
        RegisterTest registerTest = new RegisterTest();
        registerTest.newOrg(registerAddress);
        registerTest.getEthLOg(DefaultBlockParameter.valueOf(BigInteger.ONE), DefaultBlockParameter.valueOf("latest"), registerAddress);
    }

    //新建党组织机构操作
    public void newOrg(String contractAddress) {
        System.out.println("---------------------start newOrg test-----------------------------");
        String committee = "0x0dbd369a741319fa5107733e2c9db9929093e3c7";

        List<byte[]> org128 = new ArrayList<>(128);
        byte[] b1_org = utils.stringToByteArray("zhongguo");
        byte[] b2_org = utils.stringToByteArray("yinhang");
        org128.add(b1_org);
        org128.add(b2_org);

        List<String> members = new ArrayList<String>();
        members.add("0x6e6545d62e3d55b3fa16884695300ab2b2498869");
        members.add("0x0438bfcabdda99c00acf0039e6c1f3f2d78edde5");
        List<byte[]> ids = new ArrayList<>();
        String b1 = "123";
        String b2 = "456";
        byte[] b1_32 = utils.stringToByteArray(b1);
        byte[] b2_32 = utils.stringToByteArray(b2);
        ids.add(b1_32);
        ids.add(b2_32);

        Register reg = Register.load(contractAddress, this.service, transactionManager);
        TransactionReceipt receipt;
        try {
            System.out.println("reg.isValid() = " + reg.isValid());
            CompletableFuture<TransactionReceipt> future = reg.newOrg(committee, org128, members, ids,
                    this.quota, this.nonce, this.currentHeight.add(this.offset), BigInteger.valueOf(version)).sendAsync();
            Thread.sleep(6000);
            receipt = future.get(12, TimeUnit.SECONDS);
            if (receipt.getErrorMessage() == null) {
                System.out.println(" execute newOrg success");
            } else {
                System.out.println(" execute newOrg failed, " + receipt.getErrorMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---------------------end newOrg test-----------------------------");
    }
    //获取日志
    public void getEthLOg(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock, String contractAdress) {
        try {
            //构建filter,添加topics
            org.web3j.protocol.core.methods.request.EthFilter filter = new EthFilter(startBlock, endBlock, contractAdress);

            filter.addSingleTopic(null);

            List<EthLog.LogResult> logs = service.ethGetLogs(filter).send().getLogs();
            System.out.println("logs.size() = " + logs.size());
            for (int i = 0; i < logs.size(); i++) {
                EthLog.LogResult<EthLog.LogObject> result = logs.get(i);
                Log log = result.get();
                System.out.println("-----------------------------log Topics starting---------------------------------");
                List<String> strs = log.getTopics();
                System.out.println("idAddr: " + strs.get(1));
                System.out.println("infoAddr: " + strs.get(2));
                System.out.println("basicInfoAddr: " + strs.get(3));
                System.out.println("-----------------------------log Topics ending---------------------------------");

                System.out.println("-----------------------------log Data starting---------------------------------");
                String data = log.getData().substring(2);
                System.out.println("data.length() = " + data.length());
                System.out.println("切分log data:");
                for(int j=0 ; j< data.length(); j=j+64){
                    System.out.println(j + "~~" + (j+64) + ": "+ data.substring(j,j+64));
                }
                String _committee = data.substring(0, 64);
                System.out.println("_committee: "  +  _committee);

                System.out.println("-----------------------------log Data ending---------------------------------");
            }
        } catch (Throwable e) {
            System.out.println("get log" + "failed because of " + e);
        }
    }
}
