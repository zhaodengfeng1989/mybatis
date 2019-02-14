package com.zhaodf.pattern.prototypePattern;

import java.util.HashMap;
import java.util.Map;

public class Manager{
    //将注册的实例放在map中
    private Map<String,Product> showCase = new HashMap<String,Product>();

    //将原型实例注册在map中
    public void register(String name,Product proto){
        showCase.put(name,proto);
    }

    //根据原型实例创建新的复制对象
    public Product createProduct(String name){
        Product product = showCase.get(name);
        return product.createClone();
    }
}
