package com.zhaodf.pattern.factoryMethodPattern;

public class TestOperation {
    public static void main(String[] args){
        double numberA = 1;
        double numberB = 2;
        OperationFactory operationFactory = new SubFactory();
        Operation op = operationFactory.createOperation(numberA,numberB);
        System.out.println(op.getResult());
    }
}
