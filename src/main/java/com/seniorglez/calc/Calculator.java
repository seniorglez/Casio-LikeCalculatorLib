package com.seniorglez.calc;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**The entity that allows you to calculate math expressions.
 * @author Diego Dominguez Gonzalez
 */
public class Calculator {

    static private Calculator cal = null;

    protected Calculator(){
    }

    /**Method to get the instance of Calculator.
     * @return the Calculator instance.
     */
    public static Calculator getCalculatorInstance(){
        if(cal==null) cal= new Calculator();
        return cal;
    }

    //Calculate


    public double calculate(final String str) {
        return new ExpressionParser(normalizeMathExpression(str)).parse();
    }

    // formations

    /** Method that express a number on scientific notation.
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

    //dates


    /** Method that calculates the days between two dates
     * @param date1 First Date
     * @param date2 Second Date
     * @return The number of days between two Dates
     */
    public long calculateDaysBetweenDates(Date date1, Date date2){
        return TimeUnit.DAYS.convert(Math.abs(date2.getTime()-date1.getTime()),TimeUnit.MILLISECONDS);
    }

    ///**
     //* A method that calculates the exact days between two dates, that means that it not necessarily returns an int.
     //* @param date1 First Date
     //* @param date2 Second Date
     //* @return The number of days between two Dates
     //*/
    //public float calculateExactDaysBetweenDates(Date date1, Date date2){
     //   return (Math.abs(date2.getTime()-date1.getTime()))/(1000*60*60*24);
    //}

    //equations

    /** Method that returns the real solutions of a quadratic equation on an array of doubles
     * @param a the quadratic coefficient
     * @param b the linear coefficient
     * @param c the free term
     * @return An array of doubles with the solutions or null if there is not any.
     */
    public double[] calculateSecondGradeEquation(double a, double b, double c){
        double aux = (b*b) - (4*a*c);
        double x0,x1;
        double[]sol=null;
        if(aux > 0) {
            x0 = (-b + Math.sqrt(aux)) / 2*a;
            x1 = (-b - Math.sqrt(aux)) / 2*a;
            sol=new double[2];
            sol[0]=x0;
            sol[1]=x1;
        }else if(aux == 0) {//this is really a good idea?
                x0 = (-b) / 2*a;
                sol=new double[1];
                sol[0]=x0;
            }
        return sol;
    }

    //miss

    /** Method that return the number of digits of an int
     * @param number the int you want to know the number of digits
     * @return the number of digits
     */
    public int calculateNumberOfDigits(int number){
       return (int) (Math.floor(Math.log10(number)) + 1);
    }


    /**Method that returns the associated letter of a spanish Documento Nacional de Indentidad
     * @param number the number of a DNI document
     * @return the letter associated
     */
    public char calculateDNILetter(int number){
        String letters="TRWAGMYFPDXBNJZSQVHLCKE";
        int remainder = number%23;
        return letters.charAt(remainder);
    }


    //utilities

    protected String normalizeMathExpression(String s){
        Map p = new HashMap<String,String>();
        p.put("[·]","*");
        p.put("[÷]","/");
        return expressionNormalizer(s,p);
    }
    protected  String expressionNormalizer(String expression, Map <String,String> p){
        AtomicReference<String> result = new AtomicReference<>();
        result.set(expression);
        p.forEach((R,S)->result.set(normaliceChar(R,S,result.get())));
        return  result.get();
    }

    protected  String normaliceChar(String regex, String subst, String expression){
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(expression);
       return matcher.replaceAll(subst);
    }
}
