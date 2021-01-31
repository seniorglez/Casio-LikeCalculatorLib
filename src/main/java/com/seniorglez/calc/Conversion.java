package com.seniorglez.calc;

public class Conversion {

    public static String convertDecimalToBinary(long decimal){
        return Long.toBinaryString(decimal);
    }

    public static long convertBinaryToDecimal(String bin){
        return Long.parseLong(bin,2);
    }

    public static String convertDecimalToHex(long decimal){
        return Long.toHexString(decimal);
    }

    public static long convertHexToDecimal(String hex){
        return Long.parseLong(hex,16);
    }
}
