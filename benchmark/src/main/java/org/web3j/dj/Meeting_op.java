package org.web3j.dj;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.StaticArray2;
import org.web3j.abi.datatypes.generated.StaticArray4;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.2.0.
 */
public class Meeting_op extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506105978061005e6000396000f300606060405260043610610041576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063aefacda714610046575b600080fd5b341561005157600080fd5b61020860048080604001906002806020026040519081016040528092919082600260200280828437820191505050505091908060400190600280602002604051908101604052809291908260026020028082843782019150505050509190803560001916906020019091908060800190600480602002604051908101604052809291908260046020028082843782019150505050509190806080019060048060200260405190810160405280929190826004602002808284378201915050505050919080608001906004806020026040519081016040528092919082600460200280828437820191505050505091908035906020019091908035906020019091908060800190600480602002604051908101604052809291908260046020028082843782019150505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509190505061020a565b005b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638c9540d3336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15156102ce57600080fd5b6102c65a03f115156102df57600080fd5b5050506040518051905015156102f457600080fd5b88600019168a6040518082600260200280838360005b8381101561032557808201518184015260208101905061030a565b5050505090500191505060405180910390208c6040518082600260200280838360005b83811015610363578082015181840152602081019050610348565b5050505090500191505060405180910390207f4f6c69098e69314990a387f29900163de003305293c04a862f9df07551172fec338c8c8c8c8c8c8c8c604051808a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200189600460200280838360005b838110156103fc5780820151818401526020810190506103e1565b5050505090500188600460200280838360005b8381101561042a57808201518184015260208101905061040f565b5050505090500187600460200280838360005b8381101561045857808201518184015260208101905061043d565b5050505090500186815260200185815260200184600460200280838360005b83811015610492578082015181840152602081019050610477565b505050509050018060200180602001838103835285818151815260200191508051906020019080838360005b838110156104d95780820151818401526020810190506104be565b50505050905090810190601f1680156105065780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019060200280838360005b83811015610542578082015181840152602081019050610527565b505050509050019b50505050505050505050505060405180910390a450505050505050505050505600a165627a7a72305820208a75b225a3a82b4fb19db81314d9f81ee59bd69dfd34c695da61741d0a6ade0029";

    protected Meeting_op(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        super(BINARY, contractAddress, web3j, transactionManager);
    }

    public List<MeetingUploadedEventResponse> getMeetingUploadedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MeetingUploaded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicArray<Bytes32>>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<MeetingUploadedEventResponse> responses = new ArrayList<MeetingUploadedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            MeetingUploadedEventResponse typedResponse = new MeetingUploadedEventResponse();
            typedResponse.meetId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.launchOrg = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.meetType = (byte[]) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.orgId = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.meetDigest = (List<byte[]>) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._meetName = (List<byte[]>) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._basicInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.planedPersons = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.actualPersons = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.opInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.topic = (String) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.fileHash = (List<byte[]>) eventValues.getNonIndexedValues().get(8).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MeetingUploadedEventResponse> meetingUploadedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("MeetingUploaded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicArray<Bytes32>>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MeetingUploadedEventResponse>() {
            @Override
            public MeetingUploadedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                MeetingUploadedEventResponse typedResponse = new MeetingUploadedEventResponse();
                typedResponse.meetId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.launchOrg = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.meetType = (byte[]) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.orgId = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.meetDigest = (List<byte[]>) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._meetName = (List<byte[]>) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._basicInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.planedPersons = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.actualPersons = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.opInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.topic = (String) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.fileHash = (List<byte[]>) eventValues.getNonIndexedValues().get(8).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> uploadMeeting(List<byte[]> _meetId, List<byte[]> _launchOrg, byte[] _meetType, List<byte[]> _meetDigest, List<byte[]> _meetName, List<byte[]> _basicInfo, BigInteger _planedPersons, BigInteger _actualPersons, List<byte[]> _opInfo, String topic, List<byte[]> fileHashs, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        Function function = new Function(
                "uploadMeeting", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_meetId, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_launchOrg, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(_meetType), 
                new org.web3j.abi.datatypes.generated.StaticArray4<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_meetDigest, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.StaticArray4<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_meetName, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.StaticArray4<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_basicInfo, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_planedPersons), 
                new org.web3j.abi.datatypes.generated.Uint256(_actualPersons), 
                new org.web3j.abi.datatypes.generated.StaticArray4<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_opInfo, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.Utf8String(topic), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(fileHashs, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version);
    }

    public static RemoteCall<Meeting_op> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        return deployRemoteCall(Meeting_op.class, web3j, transactionManager, quota, nonce, validUntilBlock, version, BINARY);
    }

    public static Meeting_op load(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        return new Meeting_op(contractAddress, web3j, transactionManager);
    }

    public static class MeetingUploadedEventResponse {
        public byte[] meetId;

        public byte[] launchOrg;

        public byte[] meetType;

        public String orgId;

        public List<byte[]> meetDigest;

        public List<byte[]> _meetName;

        public List<byte[]> _basicInfo;

        public BigInteger planedPersons;

        public BigInteger actualPersons;

        public List<byte[]> opInfo;

        public String topic;

        public List<byte[]> fileHash;
    }
}
