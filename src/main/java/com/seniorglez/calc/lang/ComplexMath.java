package com.seniorglez.calc.lang;

import com.seniorglez.calc.numbers.ComplexNumber;

public class ComplexMath {

    //SUM 

    /**
     * Returns the sum of its arguments.
     */
    public static ComplexNumber add(ComplexNumber a, ComplexNumber b){
        return ComplexNumber.fromValue(a.getRealUnit()+b.getRealUnit(), a.getImaginaryUnit() + b.getImaginaryUnit(),ComplexNumber.BINOMIC);
    }

    /**
     * Returns the sum of its arguments.
     */
    public static ComplexNumber add(ComplexNumber a, int b){
        return ComplexNumber.fromValue(a.getRealUnit()+ b, a.getImaginaryUnit(),ComplexNumber.BINOMIC);
    }

    /**
     * Returns the sum of its arguments.
     */
    public static ComplexNumber add(ComplexNumber a, double b){
        return ComplexNumber.fromValue(a.getRealUnit()+ b, a.getImaginaryUnit(),ComplexNumber.BINOMIC);
    }

    // Multiply

    /**
     * Returns the multiply of its arguments.
     */
    public static ComplexNumber multiply(ComplexNumber a, ComplexNumber b) { // (a + bi)(c + di) = (ac - bd) + (ad + bc)i
        return ComplexNumber.fromValue(multiplyRealUnits(a,b),multiplyImaginaryUnits(a,b), ComplexNumber.BINOMIC);
    }

    /**
     * Returns the real unit of the multiply of its arguments.
     */
    private static double multiplyRealUnits(ComplexNumber a, ComplexNumber b) {
        return a.getRealUnit() * b.getRealUnit() - a.getImaginaryUnit() * b.getImaginaryUnit();
    }

    /**
     * Returns the Imaginary unit of the multiply of its arguments.
     */
    private static double multiplyImaginaryUnits(ComplexNumber a, ComplexNumber b) {
        return a.getRealUnit() * b.getImaginaryUnit() + a.getImaginaryUnit() * b.getRealUnit();
    }

    /**
     * Returns the multiply of its arguments.
     */
    public static ComplexNumber multiply(ComplexNumber a, int b) {
        return ComplexNumber.fromValue(a.getRealUnit() * b, a.getImaginaryUnit()*b, ComplexNumber.BINOMIC);
    }

    /**
     * Returns the multiply of its arguments.
     */
    public static ComplexNumber multiply(ComplexNumber a, double b) {
        return ComplexNumber.fromValue(a.getRealUnit() * b, a.getImaginaryUnit()*b, ComplexNumber.BINOMIC);
    }

    //public static ComplexNumber cbrt(ComplexNumber a) {}
}

