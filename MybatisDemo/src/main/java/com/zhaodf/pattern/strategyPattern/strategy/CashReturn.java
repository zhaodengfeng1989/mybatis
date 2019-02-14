package com.zhaodf.pattern.strategyPattern.strategy;

public class CashReturn implements CashSuper {
    //返利条件
    private double returnCondition;
    //返利金额
    private double returnMoney;

    //对于消费满多少送多少的，我们需要知道返利的条件（比如满300），我们还需要满足条件后赠费的金额
    public CashReturn(String returnCondition,String returnMoney){
        this.returnCondition = Double.parseDouble(returnCondition);
        this.returnMoney = Double.parseDouble(returnMoney);
    }

    public double cashTotal(double total) {
        //最后的商品总价是 总价减去返利价
        if(total>this.returnCondition){
            total = total - Math.floor(total/returnCondition)*returnMoney;
            return total;
        }
        return total;
    }
}
