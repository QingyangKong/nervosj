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
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.StaticArray4;
import org.web3j.abi.datatypes.generated.StaticArray5;
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
public class Basic_info_op extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555061080c8061005e6000396000f300606060405260043610610041576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063e4791e1e14610046575b600080fd5b341561005157600080fd5b6101b660048080356000191690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035600019169060200190919080356000191690602001909190803560001916906020019091908035600019169060200190919080356000191690602001909190803560001916906020019091908060a001906005806020026040519081016040528092919082600560200280828437820191505050505091908060800190600480602002604051908101604052809291908260046020028082843782019150505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506101b8565b005b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638c9540d3336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561027e57600080fd5b6102c65a03f1151561028f57600080fd5b5050506040518051905015156102a457600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16635abd1dda336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561036857600080fd5b6102c65a03f1151561037957600080fd5b5050506040518051905090508b73ffffffffffffffffffffffffffffffffffffffff167f23cfe3593f7148b2b7c46c02fbfda4bd464a1f2b2f7ceed46d617d31a15e4a258e8d8d8d8d8d8d8d8d8d8d604051808c600019166000191681526020018b600019166000191681526020018a60001916600019168152602001896000191660001916815260200188600019166000191681526020018760001916600019168152602001866000191660001916815260200185600560200280838360005b8381101561045557808201518184015260208101905061043a565b5050505090500184600460200280838360005b83811015610483578082015181840152602081019050610468565b505050509050018060200180602001838103835285818151815260200191508051906020019080838360005b838110156104ca5780820151818401526020810190506104af565b50505050905090810190601f1680156104f75780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b83811015610530578082015181840152602081019050610515565b50505050905090810190601f16801561055d5780820380516001836020036101000a031916815260200191505b509d505050505050505050505050505060405180910390a28073ffffffffffffffffffffffffffffffffffffffff1663466e94b38e8e8e8e8e8e8e8e8e8d8d336040518d63ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808d600019166000191681526020018c73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018b600019166000191681526020018a60001916600019168152602001896000191660001916815260200188600019166000191681526020018760001916600019168152602001866000191660001916815260200185600560200280838360005b8381101561068757808201518184015260208101905061066c565b5050505090500180602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019080838360005b838110156107005780820151818401526020810190506106e5565b50505050905090810190601f16801561072d5780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b8381101561076657808201518184015260208101905061074b565b50505050905090810190601f1680156107935780820380516001836020036101000a031916815260200191505b509e505050505050505050505050505050600060405180830381600087803b15156107bd57600080fd5b6102c65a03f115156107ce57600080fd5b505050505050505050505050505050505600a165627a7a7230582053486e603016132d9cc888e559c6a4ee4bdcc675472cad7a25baf807d71017b20029";

    protected Basic_info_op(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        super(BINARY, contractAddress, web3j, transactionManager);
    }

    public List<MemBasicInfoUploadedEventResponse> getMemBasicInfoUploadedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MemBasicInfoUploaded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<StaticArray5<Bytes32>>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<MemBasicInfoUploadedEventResponse> responses = new ArrayList<MemBasicInfoUploadedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            MemBasicInfoUploadedEventResponse typedResponse = new MemBasicInfoUploadedEventResponse();
            typedResponse.memAddress = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.memId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.name = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.gender = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.nation = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.birthday = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.political = (byte[]) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.marrage = (byte[]) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.extraInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.opInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(8).getValue();
            typedResponse.homeAddress = (String) eventValues.getNonIndexedValues().get(9).getValue();
            typedResponse.origin = (String) eventValues.getNonIndexedValues().get(10).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MemBasicInfoUploadedEventResponse> memBasicInfoUploadedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("MemBasicInfoUploaded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<StaticArray5<Bytes32>>() {}, new TypeReference<StaticArray4<Bytes32>>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MemBasicInfoUploadedEventResponse>() {
            @Override
            public MemBasicInfoUploadedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                MemBasicInfoUploadedEventResponse typedResponse = new MemBasicInfoUploadedEventResponse();
                typedResponse.memAddress = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.memId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.name = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.gender = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.nation = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.birthday = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.political = (byte[]) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.marrage = (byte[]) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.extraInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.opInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(8).getValue();
                typedResponse.homeAddress = (String) eventValues.getNonIndexedValues().get(9).getValue();
                typedResponse.origin = (String) eventValues.getNonIndexedValues().get(10).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> uploadMemBasicInfo(byte[] _memId, String _memAddress, byte[] _name, byte[] _gender, byte[] _nation, byte[] _birthday, byte[] _political, byte[] _marrage, List<byte[]> _extraInfo, List<byte[]> _opInfo, String _homeAddress, String _origin, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        Function function = new Function(
                "uploadMemBasicInfo", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_memId), 
                new org.web3j.abi.datatypes.Address(_memAddress), 
                new org.web3j.abi.datatypes.generated.Bytes32(_name), 
                new org.web3j.abi.datatypes.generated.Bytes32(_gender), 
                new org.web3j.abi.datatypes.generated.Bytes32(_nation), 
                new org.web3j.abi.datatypes.generated.Bytes32(_birthday), 
                new org.web3j.abi.datatypes.generated.Bytes32(_political), 
                new org.web3j.abi.datatypes.generated.Bytes32(_marrage), 
                new org.web3j.abi.datatypes.generated.StaticArray5<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_extraInfo, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.StaticArray4<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_opInfo, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.Utf8String(_homeAddress), 
                new org.web3j.abi.datatypes.Utf8String(_origin)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version);
    }

    public static RemoteCall<Basic_info_op> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        return deployRemoteCall(Basic_info_op.class, web3j, transactionManager, quota, nonce, validUntilBlock, version, BINARY);
    }

    public static Basic_info_op load(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        return new Basic_info_op(contractAddress, web3j, transactionManager);
    }

    public static class MemBasicInfoUploadedEventResponse {
        public String memAddress;

        public byte[] memId;

        public byte[] name;

        public byte[] gender;

        public byte[] nation;

        public byte[] birthday;

        public byte[] political;

        public byte[] marrage;

        public List<byte[]> extraInfo;

        public List<byte[]> opInfo;

        public String homeAddress;

        public String origin;
    }
}
