package com.seniorglez.calc.numbers;

public class ComplexNumber {

    public static final int BINOMIC = 0;
    public static final int POLAR = 1;

    private double realUnit;
    private double imaginaryUnit; 

    private ComplexNumber(double realUnit,double imaginaryUnit)
    {
        this.realUnit = realUnit;
        this.imaginaryUnit = imaginaryUnit;
    }

    public static ComplexNumber fromValue(double a, double b, int notation){
        switch (notation){
            case 0:
                return new ComplexNumber(a,b);
            case 1:
                return null; //not implemented
            default:
                return null;
        }
    }


    @Override
    public String toString() {
        return realUnit + " + " + imaginaryUnit + ("i");
    }

    public String toString(int notation) {
        switch(notation){
            case BINOMIC:
                return toString();
            case POLAR:
                return "polar";
            default:
                return "?";
        }
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

    // Static methods

    public static ComplexNumber sum(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(a.getRealUnit()+b.getRealUnit(), a.getImaginaryUnit() + b.getImaginaryUnit());
    }
}