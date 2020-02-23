package com.seniorglez.calc;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Calculator {

    static private Calculator cal = null;

    private Calculator(){
    }

    public static Calculator getCalculatorInstance(){
        if(cal==null) cal= new Calculator();
        return cal;
    }


    //Calculate

    public long calculateJSMathExpression(String ex) throws ScriptException,NumberFormatException {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        String s = engine.eval(ex).toString();
        return  Long.parseLong(s);
    }



    // formations
    public String formatScientificNotation(double d){
        NumberFormat formatter = new DecimalFormat("0.######E0");
        return formatter.format(d);
    }


    //conversions

    public String convertDecimalToBinary(long decimal){
        return Long.toBinaryString(decimal);
    }

    public long convertBinaryToDecimal(String bin){
        return Long.parseLong(bin,2);
    }

    public String convertDecimalToHex(long decimal){
        return Long.toHexString(decimal);
    }

    public long convertHexToDecimal(String hex){
        return Long.parseLong(hex,16);
    }



}
