package org.web3j.protocol.core.methods.request;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.web3j.crypto.Signature;
import org.web3j.utils.Numeric;

import org.web3j.protobuf.Blockchain;

import org.web3j.protobuf.ConvertStrByte;
import org.web3j.protobuf.Blockchain.Crypto;

import com.google.protobuf.*;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Sign;

import static org.abstractj.kalium.encoders.Encoder.HEX;

import org.abstractj.kalium.keys.SigningKey;
import org.abstractj.kalium.crypto.Hash;

/**
 * Transaction request object used the below methods.
 * <ol>
 * <li>eth_call</li>
 * <li>eth_sendTransaction</li>
 * <li>eth_estimateGas</li>
 * </ol>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction {

    private String to;
    private BigInteger nonce;  // nonce field is not present on eth_call/eth_estimateGas
    private long quota;  // gas
    private long valid_until_block;
    private int version = 0;
    private String data;
    private int chainId;
    private final Hash hash = new Hash();

    public Transaction(String to, BigInteger nonce, long quota, long valid_until_block, int version, int chainId, String data) {
        this.to = to;
        this.nonce = nonce;
        this.quota = quota;
        this.version = version;
        this.valid_until_block = valid_until_block;
        this.chainId = chainId;

        if (data != null) {
            this.data = Numeric.prependHexPrefix(data);
        }
    }

    public static Transaction createContractTransaction(
            BigInteger nonce, long quota, long valid_until_block, int version, int chainId, String init) {
        return new Transaction("", nonce, quota, valid_until_block, version, chainId, init);
    }

    public static Transaction createFunctionCallTransaction(
            String to, BigInteger nonce, long quota, long valid_until_block, int version, String data, int chainId) {

        return new Transaction(to, nonce, quota, valid_until_block, version, chainId, data);
    }

    public String getTo() {
        return to;
    }

    public String getNonce() {
        return convert(nonce);
    }

    public long getQuota() {
        return quota;
    }

    public long get_valid_until_block() {
        return valid_until_block;
    }

    public int getVersion() {
        return version;
    }

    public String getData() {
        return data;
    }

    public int getChainId() {
        return chainId;
    }


    private static String convert(BigInteger value) {
        if (value != null) {
            return Numeric.cleanHexPrefix(Numeric.encodeQuantity(value));
        } else {
            return null;  // we don't want the field to be encoded if not present
        }
    }

    public String sign(String privateKey) {
        return sign(privateKey, false);
    }

    public String sign(String privateKey, boolean isEd25519AndBlake2b) {
        byte[] tx = seriRawTransaction();
        byte[] sig = this.getSignature(privateKey, tx, isEd25519AndBlake2b);
        return seriUnverifiedTransaction(sig, tx);
    }

    public String sign(Signature signature) {
        byte[] tx = seriRawTransaction();
        byte[] sig = signature.getSignature(tx);
        return seriUnverifiedTransaction(sig, tx);
    }

    // just used to secp256k1
    public String sign(Credentials credentials) {
        byte[] tx = seriRawTransaction();
        byte[] sig = this.getSignature(credentials, tx);
        return seriUnverifiedTransaction(sig, tx);
    }

    public byte[] seriRawTransaction() {
        Blockchain.Transaction.Builder builder = Blockchain.Transaction.newBuilder();
        byte[] strbyte = ConvertStrByte.hexStringToBytes(Numeric.cleanHexPrefix(getData()));
        ByteString bdata = ByteString.copyFrom(strbyte);

        builder.setData(bdata);
        builder.setNonce(getNonce());
        builder.setTo(getTo());
        builder.setValidUntilBlock(get_valid_until_block());
        builder.setQuota(getQuota());
        builder.setVersion(getVersion());
        builder.setChainId(getChainId());

        return builder.build().toByteArray();
    }

    public String seriUnverifiedTransaction(byte[] sig, byte[] tx) {

        Blockchain.UnverifiedTransaction utx = null;
        try {
            Blockchain.Transaction transaction = Blockchain.Transaction.parseFrom(tx);
            Blockchain.UnverifiedTransaction.Builder builder1 = Blockchain.UnverifiedTransaction.newBuilder();
            builder1.setTransaction(transaction);
            builder1.setSignature(ByteString.copyFrom(sig));
            builder1.setCrypto(Crypto.SECP);
            utx = builder1.build();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String txStr = ConvertStrByte.bytesToHexString(utx.toByteArray());
        return Numeric.prependHexPrefix(txStr);
    }

    public byte[] getSignature(Credentials credentials, byte[] tx) {
        ECKeyPair keyPair = credentials.getEcKeyPair();
        Sign.SignatureData signatureData = Sign.signMessage(tx, keyPair);
        return signatureData.get_signature();
    }

    public byte[] getSignature(String privateKey, byte[] tx, boolean isEd25519AndBlake2b) {
        Hash hash = new Hash();
        byte[] sig;

        if (isEd25519AndBlake2b) {
            byte[] message = hash.blake2(tx, "CryptapeCryptape".getBytes(), null, null);
            SigningKey key = new SigningKey(privateKey, HEX);
            byte[] pk = key.getVerifyKey().toBytes();
            byte[] signature = key.sign(message);
            sig = new byte[signature.length + pk.length];
            System.arraycopy(signature, 0, sig, 0, signature.length);
            System.arraycopy(pk, 0, sig, signature.length, pk.length);
        } else {
            Credentials credentials = Credentials.create(privateKey);
            ECKeyPair keyPair = credentials.getEcKeyPair();
            Sign.SignatureData signatureData = Sign.signMessage(tx, keyPair);
            sig = signatureData.get_signature();
        }

        return sig;
    }
}
