package com.seniorglez.calc;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * The entity that allows you to calculate math expressions.
 * @author Diego Dominguez Gonzalez
 */
public class Calculator {

    static private Calculator cal = null;

    private Calculator(){
    }

    /**
     * Method to get the instance of Calculator.
     * @return the Calculator instance.
     */
    public static Calculator getCalculatorInstance(){
        if(cal==null) cal= new Calculator();
        return cal;
    }


    //Calculate

    /**
     * Method that can calculate the result of a math expression executable by JavaScript. It did not work on Android
     * @param ex the math expression executable by JavaScript.
     * @return the result of the expression.
     * @throws ScriptException
     * @throws NumberFormatException
     */
    public long calculateJSMathExpression(String ex) throws ScriptException,NumberFormatException {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        String s = engine.eval(ex).toString();
        return  Long.parseLong(s);
    }

    public double calculate(final String str) {
        return new ExpressionParser(str).parse();
    }

    // formations

    /**
     * A method that express a number on scientific notation.
     * @param number the number to format.
     * @return String with the number expressed on scientific notation.
     */
    public String formatScientificNotation(double number){
        NumberFormat formatter = new DecimalFormat("0.######E0");
        return formatter.format(number);
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

    //miss

    public int calculateNumberOfDigits(int number){
       return (int) (Math.floor(Math.log10(number)) + 1);
    }

}
