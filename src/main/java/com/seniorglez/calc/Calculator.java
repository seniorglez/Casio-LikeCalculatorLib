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
    //###########################
    //#########CALCULATE#########
    //###########################

    /**Parses and calculates the result of a math expression on a String
     * @param str that represents a math expression
     * @return the result of the math expression
     */
    public double calculate(final String str) {
        return new ExpressionParser(normalizeMathExpression(str)).parse();
    }

    //###########################
    //########STATISTICS#########
    //###########################

    /**Gets the average value of the members of an array of ints
     * @param data the values
     * @return the average of the members
     */
    public float getAverageOf(int[] data){
        double sum = 0;//because it can fail if the total sum reach the max value that an int can have
        for (int d : data) sum += d;
        return (float)(sum / (float)data.length);
    }

    /**Gets the average value of the members of an array of floats
     * @param data the values
     * @return the average of the members
     */
    public float getAverageOf(float[]data){
        float sum = 0f;
        for (float d : data) sum += d;
        return sum / data.length;
    }

    /**Gets the average value of the members of an array of doubles
     * @param data the values
     * @return the average of the members
     */
    public double getAverageOf(double[]data){
        long sum = 0;
        for(double d: data) sum +=d;
        return (double)sum/data.length;
    }


    /**Gets the variance of the members of an array of ints.
     * @param data the values
     * @return the variance
     */
    public float getVarianceOf(int[]data){
        float average = getAverageOf(data);
        float var =0;
        for(int d:data) var +=Math.pow(d-average,2);
        return var/data.length;
    }

    /**Gets the variance of the members of an array of floats.
     * @param data the values
     * @return the variance
     */
    public float getVarianceOf(float[]data){
        float average = getAverageOf(data);
        float var =0;
        for(float d:data) var +=Math.pow(d-average,2);
        return var/data.length;
    }

    public int getAbsoluteFrequency(List<String> data, String s){
        return Collections.frequency(data,s);
    }

    public float getRelativeFrequency(List<String>data,String s){
        return getAbsoluteFrequency(data,s)/(float)data.size();
    }

    //accumulative frequency && accumulative relative frequency

    public float getMedian(int[]data){
        Arrays.sort(data);
        if(data.length%2==0)return (data[data.length/2]+data[data.length/2-1]/2f);
        return data[data.length/2];
    }

    public float getMedian(float[]data){
        Arrays.sort(data);
        if(data.length%2==0)return (data[data.length/2]+data[data.length/2-1]/2f);
        return data[data.length/2];
    }




    //mode
    //percentile




    //#######################
    //########FORMAT#########
    //#######################

    /**Method that express a number on scientific notation.
     * @param number the number to format.
     * @return String with the number expressed on scientific notation.
     */
    public String formatScientificNotation(double number){
        NumberFormat formatter = new DecimalFormat("0.######E0");
        return formatter.format(number);
    }

    //###########################
    //########CONVERSION#########
    //###########################

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

    //######################
    //########DATES#########
    //######################

    /**Calculates the days between two dates
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

    /**Calculates the real solutions of a quadratic equation on an array of doubles
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

    /**Calculates the number of digits of an int
     * @param number the int you want to know the number of digits
     * @return the number of digits
     */
    public int calculateNumberOfDigits(int number){
       return (int) (Math.floor(Math.log10(number)) + 1);
    }

    /**Generates a random int between two values.
     * @param min the min value this method can return.
     * @param max the max value this method can return.
     * @return a random int between two values.
     */
    public int generateIntBetween(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**Calculates the associated letter of a spanish Documento Nacional de Indentidad
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
        p.forEach((R,S)->result.set(normalizeChar(R,S,result.get())));
        return  result.get();
    }

    protected  String normalizeChar(String regex, String subst, String expression){
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(expression);
       return matcher.replaceAll(subst);
    }


    protected int findFirst(int[] data,int target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }

    protected int findFirst(float[] data,float target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }

    protected int findFirst(byte[] data,byte target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }

    protected int findFirst(char[] data,char target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }

    protected int findFirst(short[] data,short target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }

    protected int findFirst(long[] data,long target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }

    protected int findFirst(double[] data,double target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }
    protected int findFirst(boolean[] data,boolean target){
        return IntStream.range(0, data.length).filter(i ->target ==data[i]).findFirst().orElse(-1);
    }

    protected<T> int findFirst(T[]data,T target){
        return IntStream.range(0, data.length).filter(i ->target.equals(data[i])).findFirst().orElse(-1);
    }
}
