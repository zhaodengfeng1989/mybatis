package com.zhaodf.pattern.strategyPattern.strategy;

public class CashContext{
    //持有各种促销手段的父类对象
    private CashSuper cs;

    //根据具体的促销策略,我们初始化父类实现
    public CashContext(int strategyType){
        //1.代表正常收费 2.代表打八折 3.代表满300送100
        switch (strategyType){
            case 1:
                cs = new CashNomal();
                break;
            case 2:
                cs = new CashDiscount("0.8");
                break;
            case 3:
                cs = new CashReturn("300","100");
                break;
        }
        this.cs = cs;
    }
    //直接将原总价传递，让具体的实现去处理得到最后的总价
    public double getTotal(double total) {
        return cs.cashTotal(total);
    }
}
