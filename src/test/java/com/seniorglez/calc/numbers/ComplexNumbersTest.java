package com.seniorglez.calc.numbers;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.seniorglez.calc.numbers.ComplexNumber;
import com.seniorglez.calc.lang.ComplexMath;

public class ComplexNumbersTest {

    @Test
    public void testgetAngle() { //3-4i to polar r=5 ang = -53,13
        ComplexNumber a = ComplexNumber.fromValue(3, -4, ComplexNumber.BINOMIC);
        System.out.println(a.getRadius());
        assertTrue(a.getRadius() == 5.0);

    }

}