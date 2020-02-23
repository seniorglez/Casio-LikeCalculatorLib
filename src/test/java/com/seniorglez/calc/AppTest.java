package com.seniorglez.calc;




//useful example https://examples.javacodegeeks.com/enterprise-java/maven/junit-maven-example/

import org.junit.*;

import javax.script.ScriptException;

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

}