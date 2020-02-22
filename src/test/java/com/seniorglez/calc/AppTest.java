package com.seniorglez.calc;




//useful example https://examples.javacodegeeks.com/enterprise-java/maven/junit-maven-example/

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest {
    private static Calculator calculator;

    @BeforeClass
    public static void instanceCalculator(){//idk if static test are ok
      calculator=Calculator.getCalculatorInstance();
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
    public void hi(){
        System.out.println("example");
    }
}