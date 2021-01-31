package com.seniorglez.calc.numbers;

public class ComplexNumber {

    public static final int BINOMIC = 0;
    public static final int POLAR = 1;

    private double realUnit;
    private double imaginaryUnit; 

    private ComplexNumber(double realUnit,double imaginaryUnit) {
        this.realUnit = realUnit;
        this.imaginaryUnit = imaginaryUnit;
    }

    /**
     * Returns a new ComplexNumber from the given params.
     * @param a
     * @param b
     * @param notation
     * @return
     */
    public static ComplexNumber fromValue(double a, double b, int notation) {
        switch (notation){
            case 0:
                return new ComplexNumber(a,b);
            case 1:
                return fromPolar(a, b);
            default:
                return null;
        }
    }

    /**
     * 
     * @param length length of the vertor
     * @param angle angle with the real axis
     * @return 
     */
    private static ComplexNumber fromPolar(double length, double angle) {
        return new ComplexNumber(length*Math.cos(angle),length*Math.sin(angle));
    }
    
    public String toString(int notation) {
        switch(notation){
            case BINOMIC:
                return toString();
            case POLAR:
                return toStringPolar();
            default:
                return "?";
        }
    }

    @Override
    public String toString() {
        return realUnit + " + " + imaginaryUnit + ("i");
    }

    private String toStringPolar() {
        return "Not implemenmted";
    }
    //Gettter and Setters

    public double getRealUnit() {
        return this.realUnit;
    }

    public void setRealUnit(double realUnit) {
        this.realUnit = realUnit;
    }

    public double getImaginaryUnit() {
        return this.imaginaryUnit;
    }

    public void setImaginaryUnit(double imaginaryUnit) {
        this.imaginaryUnit = imaginaryUnit;
    }

    public double getRadius() {
        return Math.sqrt(Math.pow(this.getRealUnit(), this.getImaginaryUnit()));
    }

    public double getRawAngle() {
        return Math.atan(this.getImaginaryUnit()/this.getRealUnit());
    }

    public double getAngle() {
        if(this.realUnit>=0 && this.imaginaryUnit>=0) return getRawAngle(); //if both parts are positive
        if(this.realUnit<0 &&  this.imaginaryUnit>=0) return getRawAngle() + Math.PI; // if only the imaginary part is real
        return getRawAngle() - Math.PI; // if both parts are negative
    }
}