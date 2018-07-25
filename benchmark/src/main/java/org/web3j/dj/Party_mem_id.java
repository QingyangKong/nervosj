package org.web3j.dj;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.2.0.
 */
public class Party_mem_id extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6040516109cc3803806109cc8339810160405280805190602001909190805190602001909190805182019190602001805182019190505060008151835114151561005857600080fd5b84600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550836000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600090505b82518110156101b05781818151811015156100f557fe5b9060200190602002015160026000858481518110151561011157fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081600019169055506003805480600101828161017191906101ba565b91600052602060002090016000848481518110151561018c57fe5b906020019060200201519091909150906000191690555080806001019150506100de565b505050505061020b565b8154818355818115116101e1578183600052602060002091820191016101e091906101e6565b5b505050565b61020891905b808211156102045760008160009055506001016101ec565b5090565b90565b6107b28061021a6000396000f30060606040526004361061006d576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631a50a69c146100725780631e09fab4146100dc578063ce4ce5d214610159578063d4afdb32146101aa578063da72bbe91461021a575b600080fd5b341561007d57600080fd5b61008561026f565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156100c85780820151818401526020810190506100ad565b505050509050019250505060405180910390f35b34156100e757600080fd5b61013f600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919080356000191690602001909190803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506102d1565b604051808215151515815260200191505060405180910390f35b341561016457600080fd5b610190600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061040e565b604051808215151515815260200191505060405180910390f35b34156101b557600080fd5b610200600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610465565b604051808215151515815260200191505060405180910390f35b341561022557600080fd5b610251600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506105b8565b60405180826000191660001916815260200191505060405180910390f35b610277610721565b60038054806020026020016040519081016040528092919081815260200182805480156102c757602002820191906000526020600020905b815460001916815260200190600101908083116102af575b5050505050905090565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561032e57600080fd5b81600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614151561038b57600080fd5b83600260008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208160001916905550600380548060010182816103e79190610735565b91600052602060002090016000869091909150906000191690555060019150509392505050565b60008060010260001916600260008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020546000191614159050919050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156104c257600080fd5b81600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614151561051f57600080fd5b610569600260008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205460036105d0565b50600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009055600191505092915050565b60026020528060005260406000206000915090505481565b600080610630848480548060200260200160405190810160405280929190818152602001828054801561062657602002820191906000526020600020905b8154600019168152602001906001019080831161060e575b50505050506106cf565b905082805490508110151561064857600091506106c8565b82600184805490500381548110151561065d57fe5b906000526020600020900154838281548110151561067757fe5b9060005260206000209001816000191690555082600184805490500381548110151561069f57fe5b906000526020600020900160009055828054809190600190036106c29190610735565b50600191505b5092915050565b60008090505b815181101561071a5781818151811015156106ec57fe5b90602001906020020151600019168360001916141561070d5780905061071b565b80806001019150506106d5565b5b92915050565b602060405190810160405280600081525090565b81548183558181151161075c5781836000526020600020918201910161075b9190610761565b5b505050565b61078391905b8082111561077f576000816000905550600101610767565b5090565b905600a165627a7a72305820d3d2188eef748d2456cbb03957ad9fc3a2b47b7856e8466eaa05d56c441022170029\n";

    protected Party_mem_id(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        super(BINARY, contractAddress, web3j, transactionManager);
    }

    public RemoteCall<List> queryUsers() {
        Function function = new Function("queryUsers", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}));
        return executeRemoteCallSingleValueReturn(function, List.class);
    }

    public RemoteCall<TransactionReceipt> addId(String _mem, byte[] _id, String _committee, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        Function function = new Function(
                "addId", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_mem), 
                new org.web3j.abi.datatypes.generated.Bytes32(_id), 
                new org.web3j.abi.datatypes.Address(_committee)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version);
    }

    public RemoteCall<Boolean> isMem(String _mem) {
        Function function = new Function("isMem", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_mem)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> deleteId(String _mem, String _committee, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        Function function = new Function(
                "deleteId", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_mem), 
                new org.web3j.abi.datatypes.Address(_committee)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version);
    }

    public RemoteCall<byte[]> memId(String param0) {
        Function function = new Function("memId", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public static RemoteCall<Party_mem_id> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version, String _committee, String _operator, List<String> _members, List<byte[]> _ids) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_committee), 
                new org.web3j.abi.datatypes.Address(_operator), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.Utils.typeMap(_members, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_ids, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Party_mem_id.class, web3j, transactionManager, quota, nonce, validUntilBlock, version, BINARY, encodedConstructor);
    }

    public static Party_mem_id load(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        return new Party_mem_id(contractAddress, web3j, transactionManager);
    }
}
