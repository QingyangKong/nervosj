package org.web3j.dj.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.web3j.utils.Numeric;

public class CitaUtils
{
	// String to 64 length HexString (equivalent to 32 Hex lenght)
    //byte[] myStringInByte = Numeric.hexStringToByteArray(asciiToHex("myString"));
    public static String asciiToHex(String asciiValue) {
        char[] chars = asciiValue.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }
        return hex.toString() + "".join("", Collections.nCopies(32 - (hex.length() / 2), "00"));
    }
    
    // String to 64 length HexString (equivalent to 32 Hex lenght)
    //byte[] myStringInByte = Numeric.hexStringToByteArray(asciiToHex("myString"));
    public static String hex2Hex(String hex) {
        return hex.toString() + "".join("", Collections.nCopies(32 - (hex.length() / 2), "00"));
    }
    
    // String to 64 length HexString (equivalent to 32 Hex lenght)
    //byte[] myStringInByte = Numeric.hexStringToByteArray(asciiToHex("myString"));
    public static StringBuffer str2Hex(String asciiValue) {
        char[] chars = asciiValue.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }
        return hex;
    }
    
    // String to 64 length HexString (equivalent to 128 Hex lenght)
    //byte[] myStringInByte = Numeric.hexStringToByteArray(asciiToHex("myString"));
    public static String asciiToHex128(String asciiValue) {
        char[] chars = asciiValue.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }
        return hex.toString() + "".join("", Collections.nCopies(128 - (hex.length() / 2), "00"));
    }
    
    //string to byte list(2)
	public static List<byte[]> str2ByteList(String str){
		List<byte[]> byteList = new ArrayList<>();
		StringBuffer hex = CitaUtils.str2Hex(str);
		if (hex.length() > 128) {
			System.out.println("too long");
		}else if (hex.length() > 64) {
			String hex1 = hex.substring(0, 64);
			String hex2 = hex.substring(64);
			byte[] byte1 = CitaUtils.hex2ByteArr(hex1);
			byte[] byte2 = CitaUtils.hex2ByteArr(hex2Hex(hex2));
			byteList.add(byte1);
			byteList.add(byte2);
		}else {
			byte[] byte1 = CitaUtils.hex2ByteArr(CitaUtils.asciiToHex(str));
			byte[] byte2 = CitaUtils.hex2ByteArr(CitaUtils.asciiToHex(""));
			byteList.add(byte1);
			byteList.add(byte2);
		}
		return byteList;
	}

    //string to byte list(3)
	public static List<byte[]> str2ByteList3(String str){
		List<byte[]> byteList = new ArrayList<>();
		StringBuffer hex = CitaUtils.str2Hex(str);
		if (hex.length() > 192) {
			System.out.println("too long");
		}else if (hex.length() > 128) {
			String hex1 = hex.substring(0, 64);
			String hex2 = hex.substring(64, 128);
			String hex3 = hex.substring(128);
			byte[] byte1 = CitaUtils.hex2ByteArr(hex1);
			byte[] byte2 = CitaUtils.hex2ByteArr(hex2);
			byte[] byte3 = CitaUtils.hex2ByteArr(hex2Hex(hex3));
			byteList.add(byte1);
			byteList.add(byte2);
			byteList.add(byte3);
		}else if (hex.length() > 64) {
			String hex1 = hex.substring(0, 64);
			String hex2 = hex.substring(64);
			byte[] byte1 = CitaUtils.hex2ByteArr(hex1);
			byte[] byte2 = CitaUtils.hex2ByteArr(hex2Hex(hex2));
			byte[] byte3 = CitaUtils.hex2ByteArr(CitaUtils.asciiToHex(""));
			byteList.add(byte1);
			byteList.add(byte2);
			byteList.add(byte3);
		}else {
			byte[] byte1 = CitaUtils.hex2ByteArr(CitaUtils.asciiToHex(str));
			byte[] byte2 = CitaUtils.hex2ByteArr(CitaUtils.asciiToHex(""));
			byte[] byte3 = CitaUtils.hex2ByteArr(CitaUtils.asciiToHex(""));
			byteList.add(byte1);
			byteList.add(byte2);
			byteList.add(byte3);
		}
		return byteList;
	}

    //string to byte list(4)
	public static List<byte[]> str2ByteList4(String str){
		List<byte[]> byteList = new ArrayList<>();
		StringBuffer hex = CitaUtils.str2Hex(str);
		if (hex.length() > 256) {
			System.out.println("too long");
		}else if (hex.length() > 192) {
			String hex1 = hex.substring(0, 64);
			String hex2 = hex.substring(64, 128);
			String hex3 = hex.substring(128, 192);
			String hex4 = hex.substring(192);
			byte[] byte1 = CitaUtils.hex2ByteArr(hex1);
			byte[] byte2 = CitaUtils.hex2ByteArr(hex2);
			byte[] byte3 = CitaUtils.hex2ByteArr(hex3);
			byte[] byte4 = CitaUtils.hex2ByteArr(hex2Hex(hex4));
			byteList.add(byte1);
			byteList.add(byte2);
			byteList.add(byte3);
			byteList.add(byte4);
		}else if (hex.length() > 128) {
			String hex1 = hex.substring(0, 64);
			String hex2 = hex.substring(64, 128);
			String hex3 = hex.substring(128);
			byte[] byte1 = CitaUtils.hex2ByteArr(hex1);
			byte[] byte2 = CitaUtils.hex2ByteArr(hex2);
			byte[] byte3 = CitaUtils.hex2ByteArr(hex2Hex(hex3));
			byte[] byte4 = CitaUtils.hex2ByteArr(CitaUtils.asciiToHex(""));
			byteList.add(byte1);
			byteList.add(byte2);
			byteList.add(byte3);
			byteList.add(byte4);
		}else if (hex.length() > 64) {
			String hex1 = hex.substring(0, 64);
			String hex2 = hex.substring(64);
			byte[] byte1 = CitaUtils.hex2ByteArr(hex1);
			byte[] byte2 = CitaUtils.hex2ByteArr(hex2Hex(hex2));
			byte[] byte3 = CitaUtils.hex2ByteArr(CitaUtils.asciiToHex(""));
			byte[] byte4 = CitaUtils.hex2ByteArr(CitaUtils.asciiToHex(""));
			byteList.add(byte1);
			byteList.add(byte2);
			byteList.add(byte3);
			byteList.add(byte4);
		}else {
			byte[] byte1 = CitaUtils.hex2ByteArr(CitaUtils.asciiToHex(str));
			byte[] byte2 = CitaUtils.hex2ByteArr(CitaUtils.asciiToHex(""));
			byte[] byte3 = CitaUtils.hex2ByteArr(CitaUtils.asciiToHex(""));
			byte[] byte4 = CitaUtils.hex2ByteArr(CitaUtils.asciiToHex(""));
			byteList.add(byte1);
			byteList.add(byte2);
			byteList.add(byte3);
			byteList.add(byte4);
		}
		return byteList;
	}
    
    public static byte[] hex2ByteArr(String string) {
    		return Numeric.hexStringToByteArray(string);
    }
    
    public static byte[] stringToByteArr(String string) {
    		return Numeric.hexStringToByteArray(asciiToHex(string));
    }
    
    public static byte[] stringToByteArr128(String string) {
		return Numeric.hexStringToByteArray(asciiToHex128(string));
}

    public static String strToIntStr(String stage) {
		String stageIndex = "0";
		switch (stage) {
		case "APPLY":
			stageIndex = "1";
			break;
		case "ACTIVIST":
			stageIndex = "2";
			break;
		case "OBJECT":
			stageIndex = "3";
			break;
		case "PROBATIONER":
			stageIndex = "4";
			break;
		case "REGULAR":
			stageIndex = "5";
			break;
		default:
			break;
		}
		return stageIndex;
	}
}
