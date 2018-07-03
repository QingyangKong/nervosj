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
import org.web3j.abi.datatypes.generated.Bytes32;
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
 * <p>Generated with web3j version 3.3.1.
 */
public class Meeting_op extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550610386806100606000396000f300608060405260043610610041576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063b5e76c2614610046575b600080fd5b34801561005257600080fd5b5061012e60048036038101908080356000191690602001909291908035600019169060200190929190803560001916906020019092919080356000191690602001909291908035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929080359060200190929190803590602001909291908035600019169060200190929190803560001916906020019092919080356000191690602001909291908035600019169060200190929190505050610130565b005b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638c9540d3336040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b1580156101ec57600080fd5b505af1158015610200573d6000803e3d6000fd5b505050506040513d602081101561021657600080fd5b8101908080519060200190929190505050151561023257600080fd5b836000191688600019168b600019167f89f7eb1af55377f96ec38d5d98886b454cd4134f57d7fdf8ef1f54564cf6d69d338f8e8d8d8d8c8c8c604051808a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018960001916600019168152602001886000191660001916815260200180602001878152602001868152602001856000191660001916815260200184600019166000191681526020018360001916600019168152602001828103825288818151815260200191508051906020019060200280838360005b83811015610332578082015181840152602081019050610317565b505050509050019a505050505050505050505060405180910390a450505050505050505050505600a165627a7a7230582065bcd45958d8a3978ff7445a7fbd6836acee72c585429d059590658c9f5795800029";

    protected Meeting_op(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        super(BINARY, contractAddress, web3j, transactionManager);
    }

    public List<MeetingUploadedEventResponse> getMeetingUploadedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MeetingUploaded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<MeetingUploadedEventResponse> responses = new ArrayList<MeetingUploadedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            MeetingUploadedEventResponse typedResponse = new MeetingUploadedEventResponse();
            typedResponse.launchOrg = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.meetType = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.operateDate = (byte[]) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.orgId = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.meetId = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.launchPerson = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._basicInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.planedPersons = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.actualPersons = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.operateTime = (byte[]) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.operator = (byte[]) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.desc = (byte[]) eventValues.getNonIndexedValues().get(8).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MeetingUploadedEventResponse> meetingUploadedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("MeetingUploaded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MeetingUploadedEventResponse>() {
            @Override
            public MeetingUploadedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                MeetingUploadedEventResponse typedResponse = new MeetingUploadedEventResponse();
                typedResponse.launchOrg = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.meetType = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.operateDate = (byte[]) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.orgId = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.meetId = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.launchPerson = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._basicInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.planedPersons = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.actualPersons = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.operateTime = (byte[]) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.operator = (byte[]) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.desc = (byte[]) eventValues.getNonIndexedValues().get(8).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> uploadMeeting(byte[] _meetId, byte[] _launchOrg, byte[] _launchPerson, byte[] _meetType, List<byte[]> _basicInfo, BigInteger _planedPersons, BigInteger _actualPersons, byte[] _operateDate, byte[] _operateTime, byte[] _operator, byte[] _desc, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version, BigInteger chainId) {
        Function function = new Function(
                "uploadMeeting", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_meetId), 
                new org.web3j.abi.datatypes.generated.Bytes32(_launchOrg), 
                new org.web3j.abi.datatypes.generated.Bytes32(_launchPerson), 
                new org.web3j.abi.datatypes.generated.Bytes32(_meetType), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_basicInfo, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_planedPersons), 
                new org.web3j.abi.datatypes.generated.Uint256(_actualPersons), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operateDate), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operateTime), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operator), 
                new org.web3j.abi.datatypes.generated.Bytes32(_desc)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId);
    }

    public static RemoteCall<Meeting_op> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger quota
            , BigInteger nonce, BigInteger validUntilBlock, BigInteger version, BigInteger chainId) {
        return deployRemoteCall(Meeting_op.class, web3j, transactionManager, quota, nonce, validUntilBlock, version, chainId, BINARY," ");
    }

    public static Meeting_op load(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        return new Meeting_op(contractAddress, web3j, transactionManager);
    }

    public static class MeetingUploadedEventResponse {
        public byte[] launchOrg;

        public byte[] meetType;

        public byte[] operateDate;

        public String orgId;

        public byte[] meetId;

        public byte[] launchPerson;

        public List<byte[]> _basicInfo;

        public BigInteger planedPersons;

        public BigInteger actualPersons;

        public byte[] operateTime;

        public byte[] operator;

        public byte[] desc;
    }
}
