package com.zhaodf.pattern.decoratorPattern;

public class MythChangeToFish extends MythChange{
    public MythChangeToFish(PlayDevil playDevil) {
        super(playDevil);
    }

    @Override
    public void playTheDevil() {
        System.out.println("孙大圣变成了鱼儿");
    }
}
