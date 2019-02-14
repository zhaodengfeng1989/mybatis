package com.zhaodf.pattern.factoryMethodPattern;

public class SubFactory implements OperationFactory{
    public Operation createOperation(double numberA, double numberB) {
        return new SubOperation(numberA,numberB);
    }
}
