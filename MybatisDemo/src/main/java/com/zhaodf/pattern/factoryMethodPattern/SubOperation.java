package com.zhaodf.pattern.factoryMethodPattern;

public class SubOperation implements Operation{
    private double numberA;
    private double numberB;

    public SubOperation(double numberA, double numberB){
        this.numberA = numberA;
        this.numberB = numberB;
    }

    public double getResult() {
        return this.numberA - this.numberB;
    }

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }
}
