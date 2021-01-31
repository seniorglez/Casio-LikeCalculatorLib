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
    public static ComplexNumber multiply(ComplexNumber a, int b) {
        return ComplexNumber.fromValue(a.getRealUnit() * b, a.getImaginaryUnit()*b, ComplexNumber.BINOMIC);//xd
    }

    /**
     * Returns the multiply of its arguments.
     */
    public static ComplexNumber multiply(ComplexNumber a, double b) {
        return ComplexNumber.fromValue(a.getRealUnit() * b, a.getImaginaryUnit()*b, ComplexNumber.BINOMIC);//xd
    }

    //public static ComplexNumber cbrt(ComplexNumber a) {}
}

