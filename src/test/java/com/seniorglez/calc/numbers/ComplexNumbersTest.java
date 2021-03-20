package com.seniorglez.calc.numbers;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.seniorglez.calc.numbers.ComplexNumber;
import com.seniorglez.calc.lang.ComplexMath;

public class ComplexNumbersTest {

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