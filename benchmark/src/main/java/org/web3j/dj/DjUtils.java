package org.web3j.dj;

import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class DjUtils {

    public static byte[] stringToByteArray(String value) {
        String str = String.format("%064x", new BigInteger(1, value.getBytes(StandardCharsets.UTF_8)));
        return Numeric.hexStringToByteArray(str);
    }

    public static String hexToString(String hex) {
        return new String(Numeric.hexStringToByteArray(hex), StandardCharsets.UTF_8);
    }
}
