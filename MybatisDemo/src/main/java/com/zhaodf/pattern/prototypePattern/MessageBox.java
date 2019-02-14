package com.zhaodf.pattern.prototypePattern;

public class MessageBox implements Product {
    //定义字符串的展示修饰符
    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
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
        for (int i=0;i<length+4;i++){
            System.out.print(decochar);
        }
        System.out.println();
        System.out.print(decochar+" "+s+" "+decochar);
        System.out.println();
        for (int i=0;i<length+4;i++){
            System.out.print(decochar);
        }
    }

    public char getDecochar() {
        return decochar;
    }

    public void setDecochar(char decochar) {
        this.decochar = decochar;
    }
}
