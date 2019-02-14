package com.zhaodf.pattern.proxyPattern;

public class GiveGiftImpl implements GiveGift{

    public void giveChocolate(String name) {
        System.out.println("送巧克力给B");
    }

    public void giveFlower(String name) {
        System.out.println("送花给B");
    }
}
