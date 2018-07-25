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
import org.web3j.abi.datatypes.generated.Bytes32;
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
public class Mem_id_op extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506108628061005e6000396000f30060606040526004361061004c576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806356c88648146100515780636ca213b6146100af575b600080fd5b341561005c57600080fd5b610095600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803560001916906020019091905050610100565b604051808215151515815260200191505060405180910390f35b34156100ba57600080fd5b6100e6600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610445565b604051808215151515815260200191505060405180910390f35b6000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638c9540d3336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15156101c757600080fd5b6102c65a03f115156101d857600080fd5b5050506040518051905015156101ed57600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b52caf16336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15156102b157600080fd5b6102c65a03f115156102c257600080fd5b50505060405180519050905082600019168473ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f46bb8be953686ba541284c58cd6eddc6b4d0808881894f7aa2a1e17a25eae1bb60405160405180910390a48073ffffffffffffffffffffffffffffffffffffffff16631e09fab48585336000604051602001526040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183600019166000191681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050602060405180830381600087803b151561041457600080fd5b6102c65a03f1151561042557600080fd5b50505060405180519050151561043a57600080fd5b600191505092915050565b6000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638c9540d3336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561050c57600080fd5b6102c65a03f1151561051d57600080fd5b50505060405180519050151561053257600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b52caf16336000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15156105f657600080fd5b6102c65a03f1151561060757600080fd5b5050506040518051905090508073ffffffffffffffffffffffffffffffffffffffff1663da72bbe9846000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15156106b657600080fd5b6102c65a03f115156106c757600080fd5b50505060405180519050600019168373ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167fa41ee9bc38350f9b0a7065ce32478838ab9716757ed59eab24c2975a7de3405560405160405180910390a48073ffffffffffffffffffffffffffffffffffffffff1663d4afdb3284336000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050602060405180830381600087803b151561080657600080fd5b6102c65a03f1151561081757600080fd5b50505060405180519050151561082c57600080fd5b60019150509190505600a165627a7a7230582028efa73c1b07049a03c51c83638406b6b6b2d9e714dae5b0a200f551057e933a0029\n";

    protected Mem_id_op(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        super(BINARY, contractAddress, web3j, transactionManager);
    }

    public List<IdAddedEventResponse> getIdAddedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("IdAdded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<IdAddedEventResponse> responses = new ArrayList<IdAddedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            IdAddedEventResponse typedResponse = new IdAddedEventResponse();
            typedResponse._committee = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._member = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._id = (byte[]) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<IdAddedEventResponse> idAddedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("IdAdded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, IdAddedEventResponse>() {
            @Override
            public IdAddedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                IdAddedEventResponse typedResponse = new IdAddedEventResponse();
                typedResponse._committee = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._member = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._id = (byte[]) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<IdDeletedEventResponse> getIdDeletedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("IdDeleted", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<IdDeletedEventResponse> responses = new ArrayList<IdDeletedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            IdDeletedEventResponse typedResponse = new IdDeletedEventResponse();
            typedResponse._committee = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._member = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._id = (byte[]) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<IdDeletedEventResponse> idDeletedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("IdDeleted", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, IdDeletedEventResponse>() {
            @Override
            public IdDeletedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                IdDeletedEventResponse typedResponse = new IdDeletedEventResponse();
                typedResponse._committee = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._member = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._id = (byte[]) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> addId(String _mem, byte[] _id, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        Function function = new Function(
                "addId", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_mem), 
                new org.web3j.abi.datatypes.generated.Bytes32(_id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version);
    }

    public RemoteCall<TransactionReceipt> deleteId(String _mem, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        Function function = new Function(
                "deleteId", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_mem)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version);
    }

    public static RemoteCall<Mem_id_op> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        return deployRemoteCall(Mem_id_op.class, web3j, transactionManager, quota, nonce, validUntilBlock, version, BINARY);
    }

    public static Mem_id_op load(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        return new Mem_id_op(contractAddress, web3j, transactionManager);
    }

    public static class IdAddedEventResponse {
        public String _committee;

        public String _member;

        public byte[] _id;
    }

    public static class IdDeletedEventResponse {
        public String _committee;

        public String _member;

        public byte[] _id;
    }
}
