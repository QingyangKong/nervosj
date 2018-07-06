package org.web3j.dj;

import org.web3j.crypto.Hash;
import org.web3j.protobuf.ConvertStrByte;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DjUtils {

    public static byte[] stringToByteArray(String value) {
        String str = String.format("%064x", new BigInteger(1, value.getBytes(StandardCharsets.UTF_8)));
        return Numeric.hexStringToByteArray(str);
    }

    public static String hexToString(String hex) {
        return new String(Numeric.hexStringToByteArray(hex), StandardCharsets.UTF_8);
    }

    public static int hexToInteger(String hex) {
        return Integer.parseInt(hex, 16);
    }



    public static void main(String args[]) {

        String a = "1";
        System.out.println("a.." + ConvertStrByte.bytesToHexString(stringToByteArray(a)));

        String b = "2";
        System.out.println("b.." + ConvertStrByte.bytesToHexString(stringToByteArray(b)));

//       String str2 = "uploadComOrg(bytes1[128],bytes32,bytes1[128],bytes32[3],bytes1[128],bool,bytes32,bytes32,bytes32,bytes32,bytes32,bytes32,bytes1[128])";
       String str2 = "uploadMeeting(bytes32[2],bytes32[2],bytes32,bytes32[4],bytes32[4],bytes32[4],uint256,uint256,bytes32[4],string,bytes32[])";
       System.out.println("sha()1.." + ConvertStrByte.bytesToHexString(Hash.sha3(str2.getBytes())));

       String str = "0x" + ConvertStrByte.bytesToHexString(stringToByteArray(a)) + "0x" + ConvertStrByte.bytesToHexString(stringToByteArray(b));
       System.out.println("str = " + str);
       System.out.println("sha()2.." + ConvertStrByte.bytesToHexString(Hash.sha3(str.getBytes())));
    }
}
