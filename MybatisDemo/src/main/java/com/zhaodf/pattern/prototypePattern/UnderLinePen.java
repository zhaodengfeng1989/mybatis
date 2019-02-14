package com.zhaodf.pattern.prototypePattern;

public class UnderLinePen implements Product {
    //定义字符串的展示修饰符
    private char ulchar;

    public UnderLinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    public Product createClone() {
        Product p = null;
        try {
            //这里调用Object的clone方法进行浅拷贝
            p = (Product)clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();;
        }
        return  p;
    }

    public void use(String s) {
        int length = s.length();
        System.out.println("\""+s+"\"");
        for (int i=0;i<length+4;i++){
            System.out.print(ulchar);
        }
        System.out.println();
    }
}
