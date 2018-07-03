package org.web3j.dj;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple6;
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
public class Party_mem_info extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b604051604080610c6a8339810160405280805190602001909190805190602001909190505081600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505050610ba4806100c66000396000f30060606040526004361061006d576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063369e398c146100725780633afc7afe1461010657806361cdd87b1461027a578063d0f0b2f1146102e2578063f2606e5214610340575b600080fd5b341561007d57600080fd5b6100976004808035600019169060200190919050506103aa565b604051808760058111156100a757fe5b60ff16815260200186600019166000191681526020018560001916600019168152602001846000191660001916815260200183600019166000191681526020018260001916600019168152602001965050505050505060405180910390f35b341561011157600080fd5b61026060048080356000191690602001909190803560ff16906020019091908060400190600280602002604051908101604052809291908260026020028082843782019150505050509190806040019060028060200260405190810160405280929190826002602002808284378201915050505050919080606001906003806020026040519081016040528092919082600360200280828437820191505050505091908035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919080356000191690602001909190806040019060028060200260405190810160405280929190826002602002808284378201915050505050919080356000191690602001909190803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506103f3565b604051808215151515815260200191505060405180910390f35b341561028557600080fd5b6102be60048080356000191690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610678565b604051808260058111156102ce57fe5b60ff16815260200191505060405180910390f35b34156102ed57600080fd5b61032660048080356000191690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610767565b604051808215151515815260200191505060405180910390f35b341561034b57600080fd5b61039060048080356000191690602001909190803560ff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506108c2565b604051808215151515815260200191505060405180910390f35b60026020528060005260406000206000915090508060000160009054906101000a900460ff169080600501549080600601549080600701549080600901549080600c0154905086565b60006103fd6109c7565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561045857600080fd5b82600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415156104b557600080fd5b6003801415156104c457600080fd5b610140604051908101604052808d60058111156104dd57fe5b81526020018c81526020018b81526020018a60006003811015156104fd57fe5b60200201516000191681526020018a600160038110151561051a57fe5b60200201516000191681526020018a600260038110151561053757fe5b6020020151600019168152602001898152602001886000191681526020018781526020018660001916815250915081600260008f6000191660001916815260200190815260200160002060008201518160000160006101000a81548160ff021916908360058111156105a557fe5b02179055506020820151816001019060026105c1929190610a4d565b506040820151816003019060026105d9929190610a4d565b50606082015181600501906000191690556080820151816006019060001916905560a0820151816007019060001916905560c0820151816008019080519060200190610626929190610a93565b5060e0820151816009019060001916905561010082015181600a0190600261064f929190610a4d565b5061012082015181600c01906000191690559050506001925050509a9950505050505050505050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156106d557600080fd5b81600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614151561073257600080fd5b60026000856000191660001916815260200190815260200160002060000160009054906101000a900460ff1691505092915050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156107c457600080fd5b81600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614151561082157600080fd5b600260008560001916600019168152602001908152602001600020600080820160006101000a81549060ff02191690556001820160006108619190610ae6565b6003820160006108719190610ae6565b6005820160009055600682016000905560078201600090556008820160006108999190610af4565b6009820160009055600a820160006108b19190610ae6565b600c82016000905550505092915050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561091f57600080fd5b81600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614151561097c57600080fd5b8360026000876000191660001916815260200190815260200160002060000160006101000a81548160ff021916908360058111156109b657fe5b021790555060019150509392505050565b6101a060405190810160405280600060058111156109e157fe5b81526020016109ee610b15565b81526020016109fb610b15565b8152602001600080191681526020016000801916815260200160008019168152602001610a26610b3f565b815260200160008019168152602001610a3d610b15565b8152602001600080191681525090565b8260028101928215610a82579160200282015b82811115610a81578251829060001916905591602001919060010190610a60565b5b509050610a8f9190610b53565b5090565b828054828255906000526020600020908101928215610ad5579160200282015b82811115610ad4578251829060001916905591602001919060010190610ab3565b5b509050610ae29190610b53565b5090565b506000815560010160009055565b5080546000825590600052602060002090810190610b129190610b53565b50565b60408051908101604052806002905b6000801916815260200190600190039081610b245790505090565b602060405190810160405280600081525090565b610b7591905b80821115610b71576000816000905550600101610b59565b5090565b905600a165627a7a723058204c8ff048813d030f00b41e5453ffddaf87e9d819d87a111866eaf37d95c5ff700029";

    protected Party_mem_info(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        super(BINARY, contractAddress, web3j, transactionManager);
    }

    public RemoteCall<Tuple6<BigInteger, byte[], byte[], byte[], byte[], byte[]>> infos(byte[] param0) {
        final Function function = new Function("infos", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteCall<Tuple6<BigInteger, byte[], byte[], byte[], byte[], byte[]>>(
                new Callable<Tuple6<BigInteger, byte[], byte[], byte[], byte[], byte[]>>() {
                    @Override
                    public Tuple6<BigInteger, byte[], byte[], byte[], byte[], byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple6<BigInteger, byte[], byte[], byte[], byte[], byte[]>(
                                (BigInteger) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue(), 
                                (byte[]) results.get(2).getValue(), 
                                (byte[]) results.get(3).getValue(), 
                                (byte[]) results.get(4).getValue(), 
                                (byte[]) results.get(5).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> addInfo(byte[] _memId, BigInteger _stage, List<byte[]> _appliedOrg, List<byte[]> _partyOrg, List<byte[]> _partyInfo, List<byte[]> _fileHash, byte[] _durTime, List<byte[]> _orgName, byte[] _desc, String _committee, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        Function function = new Function(
                "addInfo", 
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
                new org.web3j.abi.datatypes.generated.Bytes32(_desc), 
                new org.web3j.abi.datatypes.Address(_committee)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version);
    }

    public RemoteCall<BigInteger> queryState(byte[] _memId, String _committee) {
        Function function = new Function("queryState", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_memId), 
                new org.web3j.abi.datatypes.Address(_committee)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> deleteInfo(byte[] _memId, String _committee, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        Function function = new Function(
                "deleteInfo", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_memId), 
                new org.web3j.abi.datatypes.Address(_committee)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version);
    }

    public RemoteCall<TransactionReceipt> changeStage(byte[] _memId, BigInteger _state, String _committee, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version) {
        Function function = new Function(
                "changeStage", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_memId), 
                new org.web3j.abi.datatypes.generated.Uint8(_state), 
                new org.web3j.abi.datatypes.Address(_committee)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version);
    }

    public static RemoteCall<Party_mem_info> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger quota, BigInteger nonce, BigInteger validUntilBlock, BigInteger version, String _committee, String _operator) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_committee), 
                new org.web3j.abi.datatypes.Address(_operator)));
        return deployRemoteCall(Party_mem_info.class, web3j, transactionManager, quota, nonce, validUntilBlock, version, BINARY, encodedConstructor);
    }

    public static Party_mem_info load(String contractAddress, Web3j web3j, TransactionManager transactionManager) {
        return new Party_mem_info(contractAddress, web3j, transactionManager);
    }
}
