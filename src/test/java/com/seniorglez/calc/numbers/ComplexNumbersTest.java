package com.seniorglez.calc;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.seniorglez.calc.numbers.ComplexNumber;
import com.seniorglez.calc.lang.ComplexMath;

public class ComplexNumbersTest {
    @Test
    public void testComplexNumberAdd(){
        ComplexNumber a = ComplexNumber.fromValue(12, 4, ComplexNumber.BINOMIC);
        ComplexNumber b = ComplexNumber.fromValue(-8, 10, ComplexNumber.BINOMIC);
        ComplexNumber c = ComplexMath.add(a,b);

        assertTrue(c.getImaginaryUnit() == 14 && c.getRealUnit() ==4);
    }
}