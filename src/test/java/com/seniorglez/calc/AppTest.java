package com.seniorglez.calc;




//useful example https://examples.javacodegeeks.com/enterprise-java/maven/junit-maven-example/

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppTest {
    private Calculator calculator;

    public AppTest(){
        calculator=Calculator.getCalculatorInstance();
    }
    @BeforeClass
    public static void instanceCalculator(){//idk if static test are ok
      System.out.println("Starting tests");
    }
    @Before
    public void beforeEachTest(){
        System.out.println("Text starting");
    }
    @After
    public void afterEachTest(){
        System.out.println("Test end");
    }

    @Test
    public void testScientificNotationPositiveExpected(){
        int max = Integer.MAX_VALUE;
        assertTrue(calculator.formatScientificNotation(max).equals("2.147484E9"));
    }
    @Test
    public void  testScientificNotationNegativeExpected(){
        int min = Integer.MIN_VALUE;
        assertTrue(calculator.formatScientificNotation(min).equals("-2.147484E9"));
    }
}