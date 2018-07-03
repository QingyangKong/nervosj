package org.web3j.dj.test;

import org.web3j.crypto.Credentials;
import org.web3j.dj.Register;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.CitaTransactionManager;
import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class DeployTest {

    private static final String privateKey = "352416e1c910e413768c51390dfd791b414212b7b4fe6b1a18f58007fa894214";
    private static BigInteger quota;
    private final static int version = 0;
    private final BigInteger offset = BigInteger.valueOf(80);
    private final Random random = new Random(System.currentTimeMillis());
    private Credentials creator;
    private Web3j service;
    private Register register;
    private BigInteger nonce;
    private BigInteger currentHeight;
    private static CitaTransactionManager transactionManager;


    public DeployTest() throws Exception {
        HttpService.setDebug(true);
        this.service = Web3j.build(new HttpService("http://localhost:1337"));
        this.creator = Credentials.create(privateKey);
        transactionManager = new CitaTransactionManager(service, creator, 5, 3000);
        quota = BigInteger.valueOf(999999999);
        nonce = BigInteger.valueOf(Math.abs(this.random.nextLong()));
        currentHeight = this.service.ethBlockNumber().send().getBlockNumber();
    }

    public static void main(String args[]) throws Exception {
        DeployTest deployTest = new DeployTest();
        deployTest.deployContract();
    }

    //部署合约
    public void deployContract() {
        System.out.println("---------------------------start deployContract test:----------------------------");
        System.out.println("Creator's address:" + creator.getAddress());

        try {
            CompletableFuture<Register> tokenFuture = Register.deploy(service, transactionManager, quota,
                    this.nonce, this.currentHeight.add(this.offset), BigInteger.valueOf(version),
                    creator.getAddress()).sendAsync();
            tokenFuture.whenCompleteAsync((contract, exception) -> {
                if (exception != null) {
                    System.out.println("deploy contract failed because of " + exception);
                    exception.printStackTrace();
                    System.exit(1);
                }

                this.register = contract;
                System.out.println("--------------------------deploy success, contract address:" + this.register.getContractAddress());
                System.out.println("orgInfoOpAddr: " + this.getOrgInfoOpAddr());
                System.out.println("basicInfoOpAddr: " + this.getBasicInfoOpAddr());
                System.out.println("devProcessOpAddr: " + this.getDevProcessOpAddr());
                System.out.println("memIdAddr: " + this.getMemIdOpAddr());
                System.out.println("MeetingOpAddr: " + this.getMeetingOpAddr());
            });

        } catch (Exception e) {
            System.out.println("------deploy contract failed because of " + e);
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("---------------------------end deployContract test:----------------------------");

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
            basicInfoOpAddr = register.basicInfoOpAddr().send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return basicInfoOpAddr;
    }

    public String getDevProcessOpAddr() {
        String devProcessOpAddr = null;
        try {
            devProcessOpAddr = register.devProcessOpAddr().send();
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
            meetingOpAddr = register.meetingOpAddr().send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return meetingOpAddr;
    }
}
