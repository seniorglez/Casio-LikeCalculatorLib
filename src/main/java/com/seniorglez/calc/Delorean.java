package com.seniorglez.calc;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Delorean {


    /**Calculates the days between two dates
     * @param date1 First Date
     * @param date2 Second Date
     * @return The number of days between two Dates
     */
    public static long calculateDaysBetweenDates(Date date1, Date date2){
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






}
