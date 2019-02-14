package com.zhaodf.pattern.simpleFactory;

public class TestOperation {
    public static void main(String[] args){
        double numberA = 1;
        double numberB = 2;
        Operation op = OperationFactory.createOperation(numberA,numberB,1);
        System.out.println(op.getResult());
    }
}
