package org.web3j.dj.test;

import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
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
import org.web3j.tx.CitaTransactionManager;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MeetingOpTest {

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

    public MeetingOpTest() throws Exception {
        HttpService.setDebug(false);
        this.service = Web3j.build(new HttpService("http://localhost:1337"));
        this.creator = Credentials.create(privateKey);
        transactionManager = new CitaTransactionManager(service, creator, 5, 3000);
        quota = BigInteger.valueOf(999999999);
        nonce = BigInteger.valueOf(Math.abs(this.random.nextLong()));
        currentHeight = this.service.ethBlockNumber().send().getBlockNumber();
    }

    public static void main(String args[]) throws Exception {
        String meetingAddress = "0xd4898850edc8b816ba9fbb25fee9dc59fc4b54fd";
        MeetingOpTest meetingOpTest = new MeetingOpTest();
        meetingOpTest.uploadMeeting(meetingAddress);
        meetingOpTest.getEthLOg(DefaultBlockParameter.valueOf(BigInteger.ONE), DefaultBlockParameter.valueOf("latest"), meetingAddress);
    }

    public void uploadMeeting(String contractAddress) {
        System.out.println("----------------start uploadMeeting test-----------------------------");
        List<byte[]> _meetId = new ArrayList<>();
        _meetId.add(DjUtils.stringToByteArray("1"));
        _meetId.add(DjUtils.stringToByteArray("2"));

        List<byte[]> _launchOrg = new ArrayList<>();
        _launchOrg.add(DjUtils.stringToByteArray("中国lkdjal"));
        _launchOrg.add(DjUtils.stringToByteArray("招行kadf"));

        String meetType ="重要";
        byte[] _meetType = DjUtils.stringToByteArray(meetType);

        List<byte[]> _meetDigest = new ArrayList<>();
        _meetDigest.add(DjUtils.stringToByteArray("会议结果会议内容内容"));
        _meetDigest.add(DjUtils.stringToByteArray("会议结果20"));
        _meetDigest.add(DjUtils.stringToByteArray("会议结果3"));
        _meetDigest.add(DjUtils.stringToByteArray("会议结果4"));

        List<byte[]> _meetName = new ArrayList<>();
        _meetName.add(DjUtils.stringToByteArray("会议名字1"));
        _meetName.add(DjUtils.stringToByteArray("会议名字2"));
        _meetName.add(DjUtils.stringToByteArray("会议名字3"));
        _meetName.add(DjUtils.stringToByteArray("会议名字4"));


        List<byte[]> _basicInfo = new ArrayList<>();
        byte[] meetDate = DjUtils.stringToByteArray("日期");
        byte[] startTime = DjUtils.stringToByteArray("开始时间");
        byte[] endTime = DjUtils.stringToByteArray("结束时间");
        byte[] location = DjUtils.stringToByteArray("会议定位");
        _basicInfo.add(meetDate);
        _basicInfo.add(startTime);
        _basicInfo.add(endTime);
        _basicInfo.add(location);

        int planedPersons = 5;
        int actualPesons = 9;

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

        String _topic = "AAAA BBBB CCCC AAAA BBBBAAAA BBBB CCCC AAAA BBBBAAAA BBBB CCCC AAAA BBBB";
        List<byte[]> _fileHashs = new ArrayList<>();
        byte[] file1 = DjUtils.stringToByteArray("file1");
        byte[] file2 = DjUtils.stringToByteArray("file2");
        byte[] file3 = DjUtils.stringToByteArray("file3");
        _fileHashs.add(file1);
        _fileHashs.add(file2);
        _fileHashs.add(file3);

        Meeting_op meeting_op = Meeting_op.load(contractAddress, this.service, transactionManager);
        try{
            System.out.println("meeting_op = " + meeting_op.isValid());
            CompletableFuture<TransactionReceipt> future = meeting_op.uploadMeeting(_meetId, _launchOrg, _meetType, _meetDigest, _meetName, _basicInfo
                    , BigInteger.valueOf(planedPersons), BigInteger.valueOf(actualPesons), _opInfo,  _topic, _fileHashs, this.quota, this.nonce
                    , this.currentHeight.add(this.offset), BigInteger.valueOf(version)).sendAsync();
            TransactionReceipt transactionReceipt = future.get(12, TimeUnit.SECONDS);

            if (transactionReceipt.getErrorMessage() == null) {
                System.out.println(" execute uploadMeeting success");

                meeting_op.getMeetingUploadedEvents(transactionReceipt);
            } else {
                System.out.println(" execute uploadMeeting failed, " + transactionReceipt.getErrorMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("----------------end uploadMeeting test-----------------------------");

    }

    //获取日志
    public void getEthLOg(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock, String contractAdress) {
        try {
            //构建filter,添加topics
            EthFilter filter = new EthFilter(startBlock, endBlock, contractAdress);
            filter.addSingleTopic(null);
            filter.addSingleTopic(null);
            //filter.addSingleTopic("0x77dc3d788bb4770f074ee3940bcea3c3b09ef2668bee25bdcbad6f331f59bbce");

            List<EthLog.LogResult> logs = service.ethGetLogs(filter).send().getLogs();
            System.out.println("logs.size() = " + logs.size());
            for (int i = 0; i < logs.size(); i++) {
                EthLog.LogResult<EthLog.LogObject> result = logs.get(i);
                Log log = result.get();

                System.out.println("-----------------------------log Topics starting---------------------------------");
                List<String> strs = log.getTopics();

                System.out.println("topics:");
                System.out.println("hash: " + strs.get(0) + "  ");
                System.out.println("meetId: " + strs.get(1) + "  " + DjUtils.hexToString(strs.get(1).substring(2)));
                System.out.println("launchOrg: " + strs.get(2) + "  " + DjUtils.hexToString(strs.get(2).substring(2)));
                System.out.println("meetType: " + strs.get(3) + "  " + DjUtils.hexToString(strs.get(3).substring(2)));
                System.out.println("-----------------------------log Topics ending---------------------------------");

                System.out.println("-----------------------------log Data starting---------------------------------");
                String data = log.getData().substring(2);
                System.out.println("data.length() = " + data.length());
                System.out.println("切分log data:");
                for(int j=0 ; j< data.length(); j=j+64){
                    String s = data.substring(j,j+64);
                    System.out.println(j + "~~" + (j+64) + ": "+ s + "    " + DjUtils.hexToString(s));
                }
                System.out.println("-----------------------------log Data ending---------------------------------");
            }
        } catch (Throwable e) {
            System.out.println("get log" + "failed because of " + e);
        }
    }
}
