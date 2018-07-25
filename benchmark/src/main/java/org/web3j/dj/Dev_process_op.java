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
import org.web3j.abi.datatypes.generated.StaticArray2;
import org.web3j.abi.datatypes.generated.StaticArray3;
import org.web3j.abi.datatypes.generated.Uint8;
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
public class Dev_process_op extends Contract {
    private static final String BINARY = "60606040527f73756d6d617279000000000000000000000000000000000000000000000000006001906000191690557f6170706c7920666f722070617274790000000000000000000000000000000000600290600019169055341561006357600080fd5b336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506114ea806100b26000396000f300606060405260043610610057576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063bd3c35811461005c578063dcf62adf1461013b578063f0610e66146102d6575b600080fd5b341561006757600080fd5b61013960048080604001906002806020026040519081016040528092919082600260200280828437820191505050505091908035600019169060200190919080356000191690602001909190803560001916906020019091908035600019169060200190919080356000191690602001909190806040019060028060200260405190810160405280929190826002602002808284378201915050505050919080356000191690602001909190803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506103c7565b005b341561014657600080fd5b6102bc60048080356000191690602001909190803560ff1690602001909190806040019060028060200260405190810160405280929190826002602002808284378201915050505050919080604001906002806020026040519081016040528092919082600260200280828437820191505050505091908060600190600380602002604051908101604052809291908260036020028082843782019150505050509190803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091908035600019169060200190919080604001906002806020026040519081016040528092919082600260200280828437820191505050505091908060400190600280602002604051908101604052809291908260026020028082843782019150505050509190803560001916906020019091908035600019169060200190919080356000191690602001909190505061069e565b604051808215151515815260200191505060405180910390f35b34156102e157600080fd5b6103ad6004808060400190600280602002604051908101604052809291908260026020028082843782019150505050509190803560001916906020019091908035600019169060200190919080356000191690602001909190803560001916906020019091908035600019169060200190919080356000191690602001909190803560001916906020019091908060400190600280602002604051908101604052809291908260026020028082843782019150505050509190803560ff16906020019091905050610c5c565b604051808215151515815260200191505060405180910390f35b6000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b52caf16846000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561048e57600080fd5b6102c65a03f1151561049f57600080fd5b5050506040518051905091508190508073ffffffffffffffffffffffffffffffffffffffff1663ce4ce5d2336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561055157600080fd5b6102c65a03f1151561056257600080fd5b50505060405180519050151561057757600080fd5b6001600581111561058457fe5b88600019163373ffffffffffffffffffffffffffffffffffffffff167fe4766fda8eb34664fd943a58de837135c8d452757d712f70b974fcd76ff077c78e8e8e8d6002548e8d8f6040518089600260200280838360005b838110156105f65780820151818401526020810190506105db565b5050505090500188600019166000191681526020018760001916600019168152602001866000191660001916815260200185600019166000191681526020018460001916600019168152602001836000191660001916815260200182600260200280838360005b8381101561067857808201518184015260208101905061065d565b505050509050019850505050505050505060405180910390a45050505050505050505050565b6000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638c9540d3336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561076557600080fd5b6102c65a03f1151561077657600080fd5b50505060405180519050151561078b57600080fd5b3373ffffffffffffffffffffffffffffffffffffffff168d60058111156107ae57fe5b8f600019167f73995f9232906696eeee4915ef5da53dd7b6c58690b32248893eabe89313775c8f8f8f8f8f8f8f8f8f8f604051808b600260200280838360005b838110156108095780820151818401526020810190506107ee565b505050509050018a600260200280838360005b8381101561083757808201518184015260208101905061081c565b5050505090500189600360200280838360005b8381101561086557808201518184015260208101905061084a565b5050505090500180602001886000191660001916815260200187600260200280838360005b838110156108a557808201518184015260208101905061088a565b5050505090500186600260200280838360005b838110156108d35780820151818401526020810190506108b8565b50505050905001856000191660001916815260200184600019166000191681526020018360001916600019168152602001828103825289818151815260200191508051906020019060200280838360005b8381101561093f578082015181840152602081019050610924565b505050509050019b50505050505050505050505060405180910390a46000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f2884a7d336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b1515610a1f57600080fd5b6102c65a03f11515610a3057600080fd5b5050506040518051905090508073ffffffffffffffffffffffffffffffffffffffff16633afc7afe8f8f8f8f8f8f8f8f8e336000604051602001526040518b63ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808b600019166000191681526020018a6005811115610ab457fe5b60ff16815260200189600260200280838360005b83811015610ae3578082015181840152602081019050610ac8565b5050505090500188600260200280838360005b83811015610b11578082015181840152602081019050610af6565b5050505090500187600360200280838360005b83811015610b3f578082015181840152602081019050610b24565b5050505090500180602001866000191660001916815260200185600260200280838360005b83811015610b7f578082015181840152602081019050610b64565b5050505090500184600019166000191681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825287818151815260200191508051906020019060200280838360005b83811015610c01578082015181840152602081019050610be6565b505050509050019b505050505050505050505050602060405180830381600087803b1515610c2e57600080fd5b6102c65a03f11515610c3f57600080fd5b505050604051805190509150509c9b505050505050505050505050565b6000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638c9540d3336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b1515610d2357600080fd5b6102c65a03f11515610d3457600080fd5b505050604051805190501515610d4957600080fd5b826005811115610d5557fe5b89600019163373ffffffffffffffffffffffffffffffffffffffff167fe4766fda8eb34664fd943a58de837135c8d452757d712f70b974fcd76ff077c78f8f8f8e8e8e8e8e6040518089600260200280838360005b83811015610dc5578082015181840152602081019050610daa565b5050505090500188600019166000191681526020018760001916600019168152602001866000191660001916815260200185600019166000191681526020018460001916600019168152602001836000191660001916815260200182600260200280838360005b83811015610e47578082015181840152602081019050610e2c565b505050509050019850505050505050505060405180910390a46001546040518082600019166000191681526020019150506040518091039020600019168760405180826000191660001916815260200191505060405180910390206000191614156114ab576000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f2884a7d336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b1515610f7057600080fd5b6102c65a03f11515610f8157600080fd5b50505060405180519050905060016005811115610f9a57fe5b836005811115610fa657fe5b1415611093578073ffffffffffffffffffffffffffffffffffffffff1663f2606e528c6001336000604051602001526040518463ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180846000191660001916815260200183600581111561101e57fe5b60ff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050602060405180830381600087803b151561107657600080fd5b6102c65a03f1151561108757600080fd5b50505060405180519050505b600260058111156110a057fe5b8360058111156110ac57fe5b1415611199578073ffffffffffffffffffffffffffffffffffffffff1663f2606e528c6002336000604051602001526040518463ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180846000191660001916815260200183600581111561112457fe5b60ff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050602060405180830381600087803b151561117c57600080fd5b6102c65a03f1151561118d57600080fd5b50505060405180519050505b600360058111156111a657fe5b8360058111156111b257fe5b141561129f578073ffffffffffffffffffffffffffffffffffffffff1663f2606e528c6003336000604051602001526040518463ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180846000191660001916815260200183600581111561122a57fe5b60ff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050602060405180830381600087803b151561128257600080fd5b6102c65a03f1151561129357600080fd5b50505060405180519050505b600460058111156112ac57fe5b8360058111156112b857fe5b14156113a5578073ffffffffffffffffffffffffffffffffffffffff1663f2606e528c6004336000604051602001526040518463ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180846000191660001916815260200183600581111561133057fe5b60ff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050602060405180830381600087803b151561138857600080fd5b6102c65a03f1151561139957600080fd5b50505060405180519050505b6005808111156113b157fe5b8360058111156113bd57fe5b14156114aa578073ffffffffffffffffffffffffffffffffffffffff1663f2606e528c6005336000604051602001526040518463ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180846000191660001916815260200183600581111561143557fe5b60ff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050602060405180830381600087803b151561148d57600080fd5b6102c65a03f1151561149e57600080fd5b50505060405180519050505b5b60019150509a99505050505050505050505600a165627a7a7230582034acb8379297dacca9d424fd613a6f254089d492a10ce114660933f1128110300029\n";

    protected Dev_process_op(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        super(BINARY, contractAddress, web3j, transactionManager);
    }

    public List<MemberAddedEventResponse> getMemberAddedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MemberAdded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint8>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<StaticArray3<Bytes32>>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<Bytes32>() {}, new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<MemberAddedEventResponse> responses = new ArrayList<MemberAddedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            MemberAddedEventResponse typedResponse = new MemberAddedEventResponse();
            typedResponse.memId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.stage = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.appliedOrg = (List<byte[]>) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.partyOrg = (List<byte[]>) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.partyInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.fileHash = (List<byte[]>) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.durTime = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.orgName = (List<byte[]>) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.institution = (List<byte[]>) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.memDesc = (byte[]) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.operateData = (byte[]) eventValues.getNonIndexedValues().get(8).getValue();
            typedResponse.desc = (byte[]) eventValues.getNonIndexedValues().get(9).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MemberAddedEventResponse> memberAddedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("MemberAdded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint8>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<StaticArray3<Bytes32>>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<Bytes32>() {}, new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MemberAddedEventResponse>() {
            @Override
            public MemberAddedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                MemberAddedEventResponse typedResponse = new MemberAddedEventResponse();
                typedResponse.memId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.stage = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.operator = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.appliedOrg = (List<byte[]>) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.partyOrg = (List<byte[]>) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.partyInfo = (List<byte[]>) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.fileHash = (List<byte[]>) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.durTime = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.orgName = (List<byte[]>) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.institution = (List<byte[]>) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.memDesc = (byte[]) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.operateData = (byte[]) eventValues.getNonIndexedValues().get(8).getValue();
                typedResponse.desc = (byte[]) eventValues.getNonIndexedValues().get(9).getValue();
                return typedResponse;
            }
        });
    }

    public List<DevProcessEventResponse> getDevProcessEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("DevProcess", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint8>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<StaticArray2<Bytes32>>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DevProcessEventResponse> responses = new ArrayList<DevProcessEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DevProcessEventResponse typedResponse = new DevProcessEventResponse();
            typedResponse.operatorAddr = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.operateDate = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._type = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.orgName = (List<byte[]>) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.memId = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.memProfileId = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.operateTime = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.operateType = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.fileHash = (byte[]) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.desc = (byte[]) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.unitId = (List<byte[]>) eventValues.getNonIndexedValues().get(7).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DevProcessEventResponse> devProcessEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("DevProcess", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint8>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Bytes32>>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<StaticArray2<Bytes32>>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, DevProcessEventResponse>() {
            @Override
            public DevProcessEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DevProcessEventResponse typedResponse = new DevProcessEventResponse();
                typedResponse.operatorAddr = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.operateDate = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._type = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.orgName = (List<byte[]>) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.memId = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.memProfileId = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.operateTime = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.operateType = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.fileHash = (byte[]) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.desc = (byte[]) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.unitId = (List<byte[]>) eventValues.getNonIndexedValues().get(7).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> applyForParty(List<byte[]> _orgName, byte[] _memId, byte[] _memProfileId, byte[] _operateDate, byte[] _operateTime, byte[] _fileHash, List<byte[]> _institution, byte[] _desc, String _committee, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        Function function = new Function(
                "applyForParty", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_orgName, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(_memId), 
                new org.web3j.abi.datatypes.generated.Bytes32(_memProfileId), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operateDate), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operateTime), 
                new org.web3j.abi.datatypes.generated.Bytes32(_fileHash), 
                new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_institution, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(_desc), 
                new org.web3j.abi.datatypes.Address(_committee)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version);
    }

    public RemoteCall<TransactionReceipt> addMem(byte[] _memId, BigInteger _stage, List<byte[]> _appliedOrg, List<byte[]> _partyOrg, List<byte[]> _partyInfo, List<byte[]> _fileHash, byte[] _durTime, List<byte[]> _orgName, List<byte[]> _institution, byte[] _memDesc, byte[] _operateDate, byte[] _desc, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        Function function = new Function(
                "addMem", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_memId), 
                new org.web3j.abi.datatypes.generated.Uint8(_stage), 
                new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_appliedOrg, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_partyOrg, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.StaticArray3<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_partyInfo, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_fileHash, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(_durTime), 
                new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_orgName, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_institution, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(_memDesc), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operateDate), 
                new org.web3j.abi.datatypes.generated.Bytes32(_desc)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version);
    }

    public RemoteCall<TransactionReceipt> devProcess(List<byte[]> _orgName, byte[] _memId, byte[] _memProfileId, byte[] _operateDate, byte[] _operateTime, byte[] _operateType, byte[] _fileHash, byte[] _desc, List<byte[]> _institution, BigInteger _type, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        Function function = new Function(
                "devProcess", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_orgName, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(_memId), 
                new org.web3j.abi.datatypes.generated.Bytes32(_memProfileId), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operateDate), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operateTime), 
                new org.web3j.abi.datatypes.generated.Bytes32(_operateType), 
                new org.web3j.abi.datatypes.generated.Bytes32(_fileHash), 
                new org.web3j.abi.datatypes.generated.Bytes32(_desc), 
                new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_institution, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint8(_type)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version);
    }

    public static RemoteCall<Dev_process_op> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        return deployRemoteCall(Dev_process_op.class, web3j, transactionManager, quota, nonce, validUntilBlock, version, BINARY);
    }

    public static Dev_process_op load(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        return new Dev_process_op(contractAddress, web3j, transactionManager);
    }

    public static class MemberAddedEventResponse {
        public byte[] memId;

        public BigInteger stage;

        public String operator;

        public List<byte[]> appliedOrg;

        public List<byte[]> partyOrg;

        public List<byte[]> partyInfo;

        public List<byte[]> fileHash;

        public byte[] durTime;

        public List<byte[]> orgName;

        public List<byte[]> institution;

        public byte[] memDesc;

        public byte[] operateData;

        public byte[] desc;
    }

    public static class DevProcessEventResponse {
        public String operatorAddr;

        public byte[] operateDate;

        public BigInteger _type;

        public List<byte[]> orgName;

        public byte[] memId;

        public byte[] memProfileId;

        public byte[] operateTime;

        public byte[] operateType;

        public byte[] fileHash;

        public byte[] desc;

        public List<byte[]> unitId;
    }
}
