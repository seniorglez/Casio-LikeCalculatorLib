package com.seniorglez.calc;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.seniorglez.calc.numbers.ComplexNumber;
import com.seniorglez.calc.lang.ComplexMath;

public class ComplexMathTest {
    @Test
    public void testComplexNumberAdd() {
        ComplexNumber a = ComplexNumber.fromValue(12, 4, ComplexNumber.BINOMIC);
        ComplexNumber b = ComplexNumber.fromValue(-8, 10, ComplexNumber.BINOMIC);
        ComplexNumber c = ComplexMath.add(a,b);

        assertTrue(c.getImaginaryUnit() == 14 && c.getRealUnit() == 4);
    }

    @Test
    public void testComplexNumberPlusComplexNumber() {
        ComplexNumber a = ComplexNumber.fromValue(2, 5, ComplexNumber.BINOMIC);
        ComplexNumber b = ComplexNumber.fromValue(34, 3, ComplexNumber.BINOMIC);
        ComplexNumber c = ComplexMath.multiply(a, b);
        assertTrue(c.getImaginaryUnit() == 176 && c.getRealUnit() == 53);
    }

    @Test
    public void testComplexNumberDivideComplexNumber() {
        ComplexNumber a = ComplexNumber.fromValue(2, 4, ComplexNumber.BINOMIC);
        ComplexNumber b = ComplexNumber.fromValue(16, 8, ComplexNumber.BINOMIC);
        ComplexNumber c = ComplexMath.divide(a, b);
        assertTrue(c.getImaginaryUnit() == 0.15 && c.getRealUnit() == (0.2));
    }
}