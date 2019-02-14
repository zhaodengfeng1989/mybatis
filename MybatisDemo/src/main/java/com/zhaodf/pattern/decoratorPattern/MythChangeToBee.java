package com.zhaodf.pattern.decoratorPattern;

public class MythChangeToBee extends MythChange{
    public MythChangeToBee(PlayDevil playDevil) {
        super(playDevil);
    }

    @Override
    public void playTheDevil() {
        System.out.println("孙大圣变成了蜜蜂");
    }
}
