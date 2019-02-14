package com.zhaodf.pattern.strategyPattern.strategy;

public class CashDiscount implements CashSuper {
    private double discount;

    public CashDiscount(String discount){
        this.discount = Double.parseDouble(discount);
    }

    public double cashTotal(double total) {
        //最后的商品总价是 原总价*折扣
        return total*discount;
    }
}
