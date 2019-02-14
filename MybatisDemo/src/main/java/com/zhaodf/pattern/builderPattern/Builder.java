package com.zhaodf.pattern.builderPattern;

public abstract class Builder {
    public abstract void makeTitle(String title);
    public abstract void makeBody(String body);
    public abstract void makeEnd(String end);
    public abstract String getResult();
}
