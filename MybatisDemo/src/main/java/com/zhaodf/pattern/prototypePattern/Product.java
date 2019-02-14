package com.zhaodf.pattern.prototypePattern;

public interface Product extends Cloneable{
    Product createClone();
    void use(String s);
}
