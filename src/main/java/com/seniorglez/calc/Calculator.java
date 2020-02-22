package com.seniorglez.calc;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    static private Calculator cal = null;


    private Calculator(){
    }

    public static Calculator getCalculatorInstance(){
        if(cal==null) cal= new Calculator();
        return cal;
    }
}
