package com.zhaodf.pattern.simpleFactory;

public class OperationDiv implements Operation{
    private double numberA;
    private double numberB;

    public OperationDiv(double numberA, double numberB){
        this.numberA = numberA;
        this.numberB = numberB;
    }

    public double getResult() {
        if(this.numberB==0){
            System.out.println("除数不能为0");
            return 0;
        }
        return this.numberA / this.numberB;
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
