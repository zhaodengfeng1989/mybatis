package com.zhaodf.pattern.simpleFactory;

public class OperationFactory{
    //我们用1-代表加法，2-代表减法，3-代表乘法，4-代表除法
    public static Operation createOperation(double numberA,double numberB,int operationType){
        Operation op = null;
        switch (operationType){
            case 1:
                op = new OperationAdd(numberA,numberB);
                break;
            case 2:
                op = new OperationSub(numberA,numberB);
                break;
            case 3:
                op = new OperationMul(numberA,numberB);
                break;
            case 4:
                op = new OperationDiv(numberA,numberB);
                break;
        }
        return op;
    }
}
