package com.zhaodf.pattern.strategyPattern.strategy;

public class CashNomal implements CashSuper {

    public double cashTotal(double total) {
        return total;
    }
}
