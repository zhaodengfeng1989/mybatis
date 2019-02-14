package com.zhaodf.pattern.decoratorPattern;

public class MythChange implements PlayDevil{
    private PlayDevil playDevil;

    public MythChange(PlayDevil playDevil){
        this.playDevil = playDevil;
    }

    public void playTheDevil() {
        playDevil.playTheDevil();
    }
}
