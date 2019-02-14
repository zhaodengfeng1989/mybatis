package com.zhaodf.pattern.strategyPattern.strategy;

public class TestCash {
    public static void main(String[] args){
        //1.代表正常收费 2.代表打八折 3.代表满300送100
        int strategyType = 3;
        double oldTotal = 888;

        CashContext cc = new CashContext(strategyType);
        System.out.println("最后的总价是:"+cc.getTotal(oldTotal));
    }
}
