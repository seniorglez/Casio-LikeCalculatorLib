package com.seniorglez.calc;




//useful example https://examples.javacodegeeks.com/enterprise-java/maven/junit-maven-example/

import org.junit.*;

import javax.script.ScriptException;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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
        System.out.println("Test ending");
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

    @Test
    public void testlong2Binary(){
        assertTrue(calculator.convertDecimalToBinary(12313).equals("11000000011001"));
    }
    @Test
    public void testNegativelong2Binary(){
        assertTrue(calculator.convertDecimalToBinary(-12313).equals("1111111111111111111111111111111111111111111111111100111111100111"));
    }

    @Test
    public void testBinary2Decimal(){
        assertEquals(12313,calculator.convertBinaryToDecimal("11000000011001"));
    }

    @Ignore
    @Test
    public void testNegativeBinary2Decimal(){

    }



    @Test
    public void testDecimal2Hex(){
       assertTrue(calculator.convertDecimalToHex(158).equals("9e"));
    }

    @Ignore
    @Test
    public void testNegativeDecimal2Hex(){

    }

    @Test
    public void testHex2Decimal(){
        assertEquals(158L,calculator.convertHexToDecimal("9e"));
    }

    @Test
    public void testNegativeHex2Decimal(){
        assertEquals(-158L,calculator.convertHexToDecimal("-9e"));
    }

    @Test
    public void  testCalculateJSMathExpression(){
        try {
            assertEquals(5L,calculator.calculateJSMathExpression("3+2"));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCalculate(){
        assertTrue(7.5==calculator.calculate("((4 - 2^3 + 1) * -sqrt(3*3+4*4)) / 2"));
    }

    @Test
    public void TestCalculateNumberOfDigits(){
        assertEquals(5,calculator.calculateNumberOfDigits(12345));
    }

    @Test
    public void TestDaysBetweenDates(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        String inputString1 = "23 01 2020";
        String inputString2 = "27 01 2020";
        try {
            Date date1 = sdf.parse(inputString1);
            Date date2 = sdf.parse(inputString2);
            assertEquals(4,calculator.calculateDaysBetweenDates(date1,date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Ignore
    @Test
    public void TestExactDaysBetweenDates(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy hh mm ss");
        String inputString1 = "10 10 2013 11 30 10";
        String inputString2 = "13 10 2013 20 35 55";
        try {
            Date date1 = sdf.parse(inputString1);
            Date date2 = sdf.parse(inputString2);
          //  assertTrue(4==calculator.calculateExactDaysBetweenDates(date1,date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestQuadraticEquation2Sol(){
        double[]sol={3,2};
        double[]result=calculator.calculateSeccondGradeEquation(1,-5,6);
        Object[]arr1 ={sol};
        Object[]arr2={result};
        assertTrue(Arrays.deepEquals(arr1,arr2));
    }

    @Test
    public void  TestQuadraticEquation1Sol(){
        double[]sol={1};
        double[]result=calculator.calculateSeccondGradeEquation(1,-2,1);
        Object[]arr1 ={sol};
        Object[]arr2={result};
        assertTrue(Arrays.deepEquals(arr1,arr2));
    }

    @Test
    public void TestQuadraticEquationNoRealSol(){
        assertTrue(calculator.calculateSeccondGradeEquation(1,2,6)==null);
    }
}