package com.seniorglez.calc.numbers;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComplexNumbersTest {

    @Test
    public void testFromPolar(){
        ComplexNumber a = ComplexNumber.fromValue(5,Math.toRadians(-53.13),ComplexNumber.POLAR );
        System.out.println(a.getImaginaryUnit());
        assertEquals(-4,a.getImaginaryUnit(),0.00001d);
    }

    @Test
    public void testGetRadius() { //3-4i to polar r=5 ang = -53,13
        ComplexNumber a = ComplexNumber.fromValue(3, -4, ComplexNumber.BINOMIC);
        assertTrue(a.getRadius() == 5.0);

    }

    @Test
    public void testGetRawAngle() {
        ComplexNumber a = ComplexNumber.fromValue(3, -4, ComplexNumber.BINOMIC);
        assertTrue(a.getRawAngle()==-0.9272952180016122);
    }

    @Test
    public void testGetAngle() {
        ComplexNumber a = ComplexNumber.fromValue(3, -4, ComplexNumber.BINOMIC);
        System.out.println(a.getAngle());//I have to check this hideous thing
    }

}