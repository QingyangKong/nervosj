package org.web3j.dj.test;

import org.bouncycastle.util.encoders.Hex;
import org.web3j.crypto.Credentials;
import org.web3j.protobuf.ConvertStrByte;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.CitaTransactionManager;

import org.web3j.dj.Dev_process_op;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;
import org.web3j.dj.test.CitaUtils;
public class PartyDevTest {
    private static final String privateKey = "1f0258a4778057a8a7d97809bd209055b2fbafa654ce7d31ec7191066b9225e6";
    private static BigInteger quota;
    private final static int version = 0;
    private final BigInteger offset = BigInteger.valueOf(80);
    private final Random random = new Random(System.currentTimeMillis());
    private Credentials creator;
    private static Web3j service;
    private static Dev_process_op dev_process_op;
    private BigInteger nonce;
    private BigInteger currentHeight;
    private static CitaTransactionManager transactionManager;

    public PartyDevTest() throws Exception {
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
        PartyDevTest partyDevTest = new PartyDevTest();
        String contractAddress = "0x970e9f495799d9eaff8d27b50b0e93cf2cd6e416";
        partyDevTest.applyForParty(contractAddress);
    }

    //新建党组织机构操作
    public void applyForParty(String contractAddress) {
        System.out.println("---------------------Now, start newOrg test-----------------------------");

        String orgId = "123";
        String memberId = "123";
        String currGroup = "当前党组织";
        String operatorId = "123";
        String fileHash = "c739e51a9bfa1e9cd3d2aa8b4c3b12a69a10db4fac8eacc89cca3ba56496adf7";
        if (fileHash == null){
            fileHash = CitaUtils.asciiToHex("");
        }
        String opDate = "opDate";
        String opTime = "opDate";
        String opType = "opDate";
        String remark = "opDate";
        //prepare parameter for cita contract function
        List<byte[]> groupIdByte = CitaUtils.str2ByteList(currGroup);
        byte[] memberIdByte = CitaUtils.stringToByteArr(memberId);
        byte[] fileHashByte = null;
        try {
            fileHashByte = strToBytes(fileHash);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        byte[] opDateByte = CitaUtils.stringToByteArr(opDate);
        byte[] operatorByte = CitaUtils.stringToByteArr(operatorId);
        byte[] opTimeByte =  CitaUtils.stringToByteArr(opTime);
        byte[] remarkByte = CitaUtils.stringToByteArr(remark);
        List<byte[]> orgIdList = CitaUtils.str2ByteList(orgId);
        String committe = "0x4b5ae4567ad5d9fb92bc9afd6a657e6fa13a2523";

        Dev_process_op dev_process_op = Dev_process_op.load(contractAddress, this.service, transactionManager);
        TransactionReceipt receipt;
        try {
            System.out.println("reg.isValid()........" + dev_process_op.isValid());
            CompletableFuture<TransactionReceipt> future = dev_process_op.applyForParty(groupIdByte, memberIdByte,
                    operatorByte, opDateByte, opTimeByte, fileHashByte,orgIdList, remarkByte,committe,
                    this.quota, this.nonce, this.currentHeight.add(this.offset), BigInteger.valueOf(version)).sendAsync();
            receipt = future.get(12, TimeUnit.SECONDS);
            if (receipt.getErrorMessage() == null) {
                System.out.println(" execute newOrg success");
            } else {
                System.out.println(" execute newOrg failed, " + receipt.getErrorMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//   public byte[] strToBytes(String data) throws IOException {
//        return Hex.decode(data);
//   }
}
