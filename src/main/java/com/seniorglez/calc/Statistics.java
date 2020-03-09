package com.seniorglez.calc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.seniorglez.calc.Calc.findFirst;

public class Statistics {

    /**Gets the average value of the members of an array of ints
     * @param data the values
     * @return the average of the members
     */
    public static float getAverageOf(int[] data){
        double sum = 0;//because it can fail if the total sum reach the max value that an int can have
        for (int d : data) sum += d;
        return (float)(sum / (float)data.length);
    }
    /**Gets the average value of the members of an array of floats
     * @param data the values
     * @return the average of the members
     */
    public static float getAverageOf(float[]data){
        float sum = 0f;
        for (float d : data) sum += d;
        return sum / data.length;
    }
    /**Gets the average value of the members of an array of doubles
     * @param data the values
     * @return the average of the members
     */
    public static double getAverageOf(double[]data){
        long sum = 0;
        for(double d: data) sum +=d;
        return (double)sum/data.length;
    }
    /**Gets the variance of the members of an array of ints.
     * @param data the values
     * @return the variance
     */
    public static float getVarianceOf(int[]data){
        float average = getAverageOf(data);
        float var =0;
        for(int d:data) var +=Math.pow(d-average,2);
        return var/data.length;
    }

    /**Gets the variance of the members of an array of floats.
     * @param data the values
     * @return the variance
     */
    public static float getVarianceOf(float[]data){
        float average = getAverageOf(data);
        float var =0;
        for(float d:data) var +=Math.pow(d-average,2);
        return var/data.length;
    }

    public static int getAbsoluteFrequency(List<String> data, String s){
        return Collections.frequency(data,s);
    }

    public static float getRelativeFrequency(List<String>data,String s){
        return getAbsoluteFrequency(data,s)/(float)data.size();
    }

    //accumulative frequency && accumulative relative frequency

    public static float getMedian(int[]data){
        Arrays.sort(data);
        if(data.length%2==0)return (data[data.length/2]+data[data.length/2-1]/2f);
        return data[data.length/2];
    }

    public static float getMedian(float[]data){
        Arrays.sort(data);
        if(data.length%2==0)return (data[data.length/2]+data[data.length/2-1]/2f);
        return data[data.length/2];
    }
    //mode
    //percentile
    public static float getPercentileOfPosition(int[]data,int position){
        return ((position-0.5f)/data.length)*100;
    }

    public static float getPercentileOfValue(int[]data,int value){
        Arrays.sort(data);
        int position = findFirst(data,value);
        return getPercentileOfPosition(data,position);
    }
}
