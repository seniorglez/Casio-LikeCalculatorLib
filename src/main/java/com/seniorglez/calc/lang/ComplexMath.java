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


    //Division
    public static ComplexNumber divide(ComplexNumber a, ComplexNumber b) {
        return ComplexNumber.fromValue(divideRealUnits(a, b),divideImaginaryUnits(a, b), ComplexNumber.BINOMIC);
    }

    /**
     * Returns the real unit of the division of its arguments.
     */
    private static double divideRealUnits(ComplexNumber a, ComplexNumber b) {
        return ((a.getRealUnit() * b.getRealUnit() + a.getImaginaryUnit()* b.getImaginaryUnit())/(Math.pow(b.getRealUnit(),2) + Math.pow(b.getImaginaryUnit(),2)));
    }

    /**
     * Returns the imaginary unit of the division of its arguments.
     */
    private static double divideImaginaryUnits(ComplexNumber a, ComplexNumber b) {
        return ((-a.getRealUnit() * b.getImaginaryUnit() + a.getImaginaryUnit()* b.getRealUnit())/(Math.pow(b.getRealUnit(),2) + Math.pow(b.getImaginaryUnit(),2)));
    }
    /**
     * Returns the division of its arguments.
     */
    public static ComplexNumber divide(ComplexNumber a, double b) {
        return ComplexNumber.fromValue(a.getRealUnit()/b, a.getImaginaryUnit()/b, ComplexNumber.BINOMIC);
    }

    /**
     * Returns an array of ComplexNumber which contains the nth roots of the given complex number.
     * @param a The complex number.
     * @param grade The grade of the roots
     * @return an array of ComplexNumber which contains the nth roots of the given complex number.
     */
    public static ComplexNumber[] root(ComplexNumber a, int grade) {
        return root(grade-1,grade,Math.pow(a.getRadius(), 1/grade), a.getAngle(),new ComplexNumber[grade]);
    }

    /**
     * Returns an array which contains the nth roots of the given complex number.
     *
     * @param k A counter which have the root value minus one. (θ + 2πk)/n k = 0,1,2,..., n-1
     * @param radius The precalculated radius of the root.
     * @param angle
     * @param result
     * @return
     */
    private static ComplexNumber[] root(int k,int grade, double radius, double angle, ComplexNumber[] result) {
        result[k] = ComplexNumber.fromValue(radius,getRootAngle(k,grade,angle),ComplexNumber.POLAR);
        return (k == 0)? result : root(k-1,grade,radius,angle,result);
    }

    private static double getRootAngle(int k,int grade, double angle) { //(θ + 2πk)/n
        return (angle + 2 * Math.PI * k)/grade;
    }

    //public static ComplexNumber cbrt(ComplexNumber a) {}
}

