package com.seniorglez.calc;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * @author Diego Dominguez Gonzalez
 */
public class Calc {


    //###########################
    //#########CALCULATE#########
    //###########################

    /**Parses and calculates the result of a math expression on a String
     * @param str that represents a math expression
     * @return the result of the math expression
     */
    public static double calculate(final String str) {
        return new ExpressionParser(normalizeMathExpression(str)).parse();
    }


    //#######################
    //########FORMAT#########
    //#######################

    /**Method that express a number on scientific notation.
     * @param number the number to format.
     * @return String with the number expressed on scientific notation.
     */
    public static String formatScientificNotation(double number){
        NumberFormat formatter = new DecimalFormat("0.######E0");
        return formatter.format(number);
    }

    //###########################
    //########CONVERSION#########
    //###########################

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


    //equations

    /**Calculates the real solutions of a quadratic equation on an array of doubles
     * @param a the quadratic coefficient
     * @param b the linear coefficient
     * @param c the free term
     * @return An array of doubles with the solutions or null if there is not any.
     */
    public static double[] calculateSecondGradeEquation(double a, double b, double c){
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

    /**Calculates the number of digits of an int
     * @param number the int you want to know the number of digits
     * @return the number of digits
     */
    public static int calculateNumberOfDigits(int number){
       return (int) (Math.floor(Math.log10(number)) + 1);
    }

    /**Generates a random int between two values.
     * @param min the min value this method can return.
     * @param max the max value this method can return.
     * @return a random int between two values.
     */
    public static int generateIntBetween(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**Calculates the associated letter of a spanish Documento Nacional de Indentidad
     * @param number the number of a DNI document
     * @return the letter associated
     */
    public static char calculateDNILetter(int number){
        String letters="TRWAGMYFPDXBNJZSQVHLCKE";
        int remainder = number%23;
        return letters.charAt(remainder);
    }


    //utilities

    protected static String normalizeMathExpression(String s){
        Map p = new HashMap<String,String>();
        p.put("[·]","*");
        p.put("[÷]","/");
        return expressionNormalizer(s,p);
    }
    protected static String expressionNormalizer(String expression, Map <String,String> p){
        AtomicReference<String> result = new AtomicReference<>();
        result.set(expression);
        p.forEach((R,S)->result.set(normalizeChar(R,S,result.get())));
        return  result.get();
    }

    protected  static String normalizeChar(String regex, String subst, String expression){
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(expression);
       return matcher.replaceAll(subst);
    }


    protected static int findFirst(int[] data,int target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }

    protected static int findFirst(float[] data,float target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }

    protected static int findFirst(byte[] data,byte target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }

    protected static int findFirst(char[] data,char target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }

    protected static int findFirst(short[] data,short target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }

    protected static int findFirst(long[] data,long target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }

    protected static int findFirst(double[] data,double target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }
    protected static int findFirst(boolean[] data,boolean target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }

    protected static <T> int findFirst(T[]data,T target){
        return IntStream.range(0, data.length).filter(i ->target.equals(data[i])).findFirst().orElse(-1);
    }
}
