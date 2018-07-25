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
    private static final String BINARY = "6060604052341561000f57600080fd5b336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506108c78061005e6000396000f30060606040526004361061004c576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063a52573b114610051578063af9ce6a414610140575b600080fd5b341561005c57600080fd5b6101266004808060400190600280602002604051908101604052809291908260026020028082843782019150505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091908035600019169060200190919080356000191690602001909190803560001916906020019091908035600019169060200190919080356000191690602001909190803560001916906020019091905050610308565b604051808215151515815260200191505060405180910390f35b341561014b57600080fd5b61030660048080604001906002806020026040519081016040528092919082600260200280828437820191505050505091908035600019169060200190919080608001906004806020026040519081016040528092919082600460200280828437820191505050505091908060800190600480602002604051908101604052809291908260046020028082843782019150505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919080351515906020019091908060800190600480602002604051908101604052809291908260046020028082843782019150505050509190803560001916906020019091908035600019169060200190919080356000191690602001909190803560001916906020019091908060400190600280602002604051908101604052809291908260026020028082843782019150505050509190505061051a565b005b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638c9540d3336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15156103ce57600080fd5b6102c65a03f115156103df57600080fd5b5050506040518051905015156103f457600080fd5b836000191686600019167fa4956d4c0662cb9140c8c53fc4ac05308c93891abfffbac328c3ce0e662c203f8b8b8b8a89896040518087600260200280838360005b83811015610450578082015181840152602081019050610435565b50505050905001806020018660001916600019168152602001856000191660001916815260200184600019166000191681526020018360001916600019168152602001828103825287818151815260200191508051906020019080838360005b838110156104cb5780820151818401526020810190506104b0565b50505050905090810190601f1680156104f85780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390a36001905098975050505050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638c9540d3336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15156105de57600080fd5b6102c65a03f115156105ef57600080fd5b50505060405180519050151561060457600080fd5b84600019168b6040518082600460200280838360005b8381101561063557808201518184015260208101905061061a565b5050505090500191505060405180910390207f835373ac506a9efab6678dfb6aa80a40b99882297feab141b6e83d1c635720018f8f8f8f8f8f8f8f8e8e8e8e604051808d600260200280838360005b8381101561069f578082015181840152602081019050610684565b505050509050018c600019166000191681526020018b600460200280838360005b838110156106db5780820151818401526020810190506106c0565b505050509050018a600460200280838360005b838110156107095780820151818401526020810190506106ee565b5050505090500180602001806020018915151515815260200188600460200280838360005b8381101561074957808201518184015260208101905061072e565b5050505090500187600019166000191681526020018660001916600019168152602001856000191660001916815260200184600260200280838360005b838110156107a1578082015181840152602081019050610786565b5050505090500183810383528b818151815260200191508051906020019080838360005b838110156107e05780820151818401526020810190506107c5565b50505050905090810190601f16801561080d5780820380516001836020036101000a031916815260200191505b5083810382528a818151815260200191508051906020019080838360005b8381101561084657808201518184015260208101905061082b565b50505050905090810190601f1680156108735780820380516001836020036101000a031916815260200191505b509e50505050505050505050505050505060405180910390a3505050505050505050505050505600a165627a7a72305820004cfaf7e7f43f68b79f4abceb829c4cf7c881101773a25aa948449f12720a540029\n";

    protected Org_info_op(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        super(BINARY, contractAddress, web3j, transactionManager);
    }

    public List<ComOrgUploadedEventResponse> getComOrgUploadedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("ComOrgUploaded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<Bytes32>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bool>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<StaticArray2<Bytes32>>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ComOrgUploadedEventResponse> responses = new ArrayList<ComOrgUploadedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ComOrgUploadedEventResponse typedResponse = new ComOrgUploadedEventResponse();
            typedResponse.orgName = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.operateDate = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.orgId = (List<byte[]>) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.orgType = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._orgName = (List<byte[]>) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.parentOrgName = (List<byte[]>) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.relatedOrgInfo = (String) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.positionInfo = (String) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.undo = (Boolean) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.uploadInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.operateTime = (byte[]) eventValues.getNonIndexedValues().get(8).getValue();
            typedResponse.operator = (byte[]) eventValues.getNonIndexedValues().get(9).getValue();
            typedResponse.desc = (byte[]) eventValues.getNonIndexedValues().get(10).getValue();
            typedResponse.institution = (List<byte[]>) eventValues.getNonIndexedValues().get(11).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ComOrgUploadedEventResponse> comOrgUploadedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("ComOrgUploaded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<Bytes32>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bool>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<StaticArray2<Bytes32>>() {}));
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
                typedResponse._orgName = (List<byte[]>) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.parentOrgName = (List<byte[]>) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.relatedOrgInfo = (String) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.positionInfo = (String) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.undo = (Boolean) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.uploadInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.operateTime = (byte[]) eventValues.getNonIndexedValues().get(8).getValue();
                typedResponse.operator = (byte[]) eventValues.getNonIndexedValues().get(9).getValue();
                typedResponse.desc = (byte[]) eventValues.getNonIndexedValues().get(10).getValue();
                typedResponse.institution = (List<byte[]>) eventValues.getNonIndexedValues().get(11).getValue();
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
            typedResponse.operateDate = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.operateType = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.orgId = (List<byte[]>) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.undoReason = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.effectiveTime = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.operateTime = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.operator = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.desc = (byte[]) eventValues.getNonIndexedValues().get(5).getValue();
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
                typedResponse.operateDate = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.operateType = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.orgId = (List<byte[]>) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.undoReason = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.effectiveTime = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.operateTime = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.operator = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.desc = (byte[]) eventValues.getNonIndexedValues().get(5).getValue();
                return typedResponse;
            }
        });
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

    public RemoteCall<TransactionReceipt> uploadComOrg(List<byte[]> _orgId, byte[] _orgType, List<byte[]> _orgName, List<byte[]> _parentOrgName, String _relatedOrgInfo, String _positionInfo, Boolean _undo, List<byte[]> _uploadInfo, byte[] _operateDate, byte[] _operateTime, byte[] _operator, byte[] _desc, List<byte[]> _institution, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        Function function = new Function(
                "uploadComOrg", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_orgId, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(_orgType), 
                new org.web3j.abi.datatypes.generated.StaticArray4<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_orgName, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.StaticArray4<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_parentOrgName, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.Utf8String(_relatedOrgInfo), 
                new org.web3j.abi.datatypes.Utf8String(_positionInfo), 
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

        public List<byte[]> _orgName;

        public List<byte[]> parentOrgName;

        public String relatedOrgInfo;

        public String positionInfo;

        public Boolean undo;

        public List<byte[]> uploadInfo;

        public byte[] operateTime;

        public byte[] operator;

        public byte[] desc;

        public List<byte[]> institution;
    }

    public static class ComOrgUndoEventResponse {
        public byte[] operateDate;

        public byte[] operateType;

        public List<byte[]> orgId;

        public String undoReason;

        public byte[] effectiveTime;

        public byte[] operateTime;

        public byte[] operator;

        public byte[] desc;
    }
}
