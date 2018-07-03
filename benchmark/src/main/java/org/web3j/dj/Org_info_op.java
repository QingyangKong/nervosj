package org.web3j.dj;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.StaticArray2;
import org.web3j.abi.datatypes.generated.StaticArray4;
import org.web3j.abi.datatypes.generated.StaticArray8;
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
public class Org_info_op extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506107938061005e6000396000f30060606040526004361061004c576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063141dc3b414610051578063a52573b1146101c0575b600080fd5b341561005c57600080fd5b6101be600480806040019060028060200260405190810160405280929190826002602002808284378201915050505050919080356000191690602001909190806080019060048060200260405190810160405280929190826004602002808284378201915050505050919080610100019060088060200260405190810160405280929190826008602002808284378201915050505050919080608001906004806020026040519081016040528092919082600460200280828437820191505050505091908035151590602001909190806080019060048060200260405190810160405280929190826004602002808284378201915050505050919080356000191690602001909190803560001916906020019091908035600019169060200190919080356000191690602001909190806040019060028060200260405190810160405280929190826002602002808284378201915050505050919050506102af565b005b34156101cb57600080fd5b6102956004808060400190600280602002604051908101604052809291908260026020028082843782019150505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091908035600019169060200190919080356000191690602001909190803560001916906020019091908035600019169060200190919080356000191690602001909190803560001916906020019091905050610555565b604051808215151515815260200191505060405180910390f35b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638c9540d3336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561037357600080fd5b6102c65a03f1151561038457600080fd5b50505060405180519050151561039957600080fd5b84600019168a6040518082600460200280838360005b838110156103ca5780820151818401526020810190506103af565b5050505090500191505060405180910390207f38414c3550891178750e82446ea0dfe31f9c282fdf327fc395d31a402e0c2ab78e8e8d8d8d8d8c8c8c8c604051808b600260200280838360005b83811015610432578082015181840152602081019050610417565b505050509050018a6000191660001916815260200189600860200280838360005b8381101561046e578082015181840152602081019050610453565b5050505090500188600460200280838360005b8381101561049c578082015181840152602081019050610481565b505050509050018715151515815260200186600460200280838360005b838110156104d45780820151818401526020810190506104b9565b5050505090500185600019166000191681526020018460001916600019168152602001836000191660001916815260200182600260200280838360005b8381101561052c578082015181840152602081019050610511565b505050509050019a505050505050505050505060405180910390a3505050505050505050505050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638c9540d3336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561061b57600080fd5b6102c65a03f1151561062c57600080fd5b50505060405180519050151561064157600080fd5b836000191686600019167fa4956d4c0662cb9140c8c53fc4ac05308c93891abfffbac328c3ce0e662c203f8b8b8b8a89896040518087600260200280838360005b8381101561069d578082015181840152602081019050610682565b50505050905001806020018660001916600019168152602001856000191660001916815260200184600019166000191681526020018360001916600019168152602001828103825287818151815260200191508051906020019080838360005b838110156107185780820151818401526020810190506106fd565b50505050905090810190601f1680156107455780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390a360019050989750505050505050505600a165627a7a72305820a1cfb657c10751f86febe52dbe509ed8cbb652656086cba7490b89c5f625b1490029";

    protected Org_info_op(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        super(BINARY, contractAddress, web3j, transactionManager);
    }

    public List<ComOrgUploadedEventResponse> getComOrgUploadedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("ComOrgUploaded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<Bytes32>() {}, new TypeReference<StaticArray8<Bytes32>>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Bool>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<StaticArray2<Bytes32>>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ComOrgUploadedEventResponse> responses = new ArrayList<ComOrgUploadedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ComOrgUploadedEventResponse typedResponse = new ComOrgUploadedEventResponse();
            typedResponse.orgName = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.operateDate = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.orgId = (List<byte[]>) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.orgType = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.orgBaseInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.positionInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.undo = (Boolean) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.uploadInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.operateTime = (byte[]) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.operator = (byte[]) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.desc = (byte[]) eventValues.getNonIndexedValues().get(8).getValue();
            typedResponse._institution = (List<byte[]>) eventValues.getNonIndexedValues().get(9).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ComOrgUploadedEventResponse> comOrgUploadedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("ComOrgUploaded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<Bytes32>() {}, new TypeReference<StaticArray8<Bytes32>>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Bool>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<StaticArray2<Bytes32>>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ComOrgUploadedEventResponse>() {
            @Override
            public ComOrgUploadedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ComOrgUploadedEventResponse typedResponse = new ComOrgUploadedEventResponse();
                typedResponse.orgName = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.operateDate = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.orgId = (List<byte[]>) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.orgType = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.orgBaseInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.positionInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.undo = (Boolean) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.uploadInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.operateTime = (byte[]) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.operator = (byte[]) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.desc = (byte[]) eventValues.getNonIndexedValues().get(8).getValue();
                typedResponse._institution = (List<byte[]>) eventValues.getNonIndexedValues().get(9).getValue();
                return typedResponse;
            }
        });
    }

    public List<ComOrgUndoEventResponse> getComOrgUndoEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("ComOrgUndo", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ComOrgUndoEventResponse> responses = new ArrayList<ComOrgUndoEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ComOrgUndoEventResponse typedResponse = new ComOrgUndoEventResponse();
            typedResponse._operateDate = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._operateType = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._orgId = (List<byte[]>) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._undoReason = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._effectiveTime = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._operateTime = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse._operator = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse._desc = (byte[]) eventValues.getNonIndexedValues().get(5).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ComOrgUndoEventResponse> comOrgUndoEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("ComOrgUndo", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ComOrgUndoEventResponse>() {
            @Override
            public ComOrgUndoEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ComOrgUndoEventResponse typedResponse = new ComOrgUndoEventResponse();
                typedResponse._operateDate = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._operateType = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._orgId = (List<byte[]>) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._undoReason = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._effectiveTime = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._operateTime = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse._operator = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse._desc = (byte[]) eventValues.getNonIndexedValues().get(5).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> uploadComOrg(List<byte[]> _orgId, byte[] _orgType, List<byte[]> _orgName, List<byte[]> _orgBaseInfo, List<byte[]> _positionInfo, Boolean _undo, List<byte[]> _uploadInfo, byte[] _operateDate, byte[] _operateTime, byte[] _operator, byte[] _desc, List<byte[]> _institution, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        Function function = new Function(
                "uploadComOrg", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_orgId, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(_orgType), 
                new org.web3j.abi.datatypes.generated.StaticArray4<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_orgName, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.StaticArray8<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_orgBaseInfo, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.StaticArray4<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_positionInfo, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.Bool(_undo), 
                new org.web3j.abi.datatypes.generated.StaticArray4<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_uploadInfo, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operateDate), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operateTime), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operator), 
                new org.web3j.abi.datatypes.generated.Bytes32(_desc), 
                new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_institution, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version);
    }

    public RemoteCall<TransactionReceipt> undoComOrg(List<byte[]> _orgId, String _undoReason, byte[] _effectiveTime, byte[] _operateDate, byte[] _operateTime, byte[] _operateType, byte[] _operator, byte[] _desc, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        Function function = new Function(
                "undoComOrg", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_orgId, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.Utf8String(_undoReason), 
                new org.web3j.abi.datatypes.generated.Bytes32(_effectiveTime), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operateDate), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operateTime), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operateType), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operator), 
                new org.web3j.abi.datatypes.generated.Bytes32(_desc)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version);
    }

    public static RemoteCall<Org_info_op> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        return deployRemoteCall(Org_info_op.class, web3j, transactionManager, quota, nonce, validUntilBlock, version, BINARY);
    }

    public static Org_info_op load(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        return new Org_info_op(contractAddress, web3j, transactionManager);
    }

    public static class ComOrgUploadedEventResponse {
        public byte[] orgName;

        public byte[] operateDate;

        public List<byte[]> orgId;

        public byte[] orgType;

        public List<byte[]> orgBaseInfo;

        public List<byte[]> positionInfo;

        public Boolean undo;

        public List<byte[]> uploadInfo;

        public byte[] operateTime;

        public byte[] operator;

        public byte[] desc;

        public List<byte[]> _institution;
    }

    public static class ComOrgUndoEventResponse {
        public byte[] _operateDate;

        public byte[] _operateType;

        public List<byte[]> _orgId;

        public String _undoReason;

        public byte[] _effectiveTime;

        public byte[] _operateTime;

        public byte[] _operator;

        public byte[] _desc;
    }
}
