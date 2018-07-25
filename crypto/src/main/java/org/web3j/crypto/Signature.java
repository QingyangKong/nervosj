package org.web3j.crypto;

public abstract class Signature {

    public abstract byte[] getSignature(byte[] tx);

    public abstract String getPublicKey();

    public abstract String getAddress();
}
