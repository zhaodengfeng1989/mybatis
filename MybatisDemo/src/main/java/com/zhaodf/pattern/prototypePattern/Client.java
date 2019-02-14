package com.zhaodf.pattern.prototypePattern;

public class Client {
    public static void main(String[] args){
        Manager manager = new Manager();
        UnderLinePen ulPen = new UnderLinePen('-');
        MessageBox mb = new MessageBox('*');
        manager.register("ulpen",ulPen);
        manager.register("msgBox",mb);
        Product p1 = manager.createProduct("ulpen");
        p1.use("Hello,World");
        Product p2 = manager.createProduct("msgBox");
        p2.use("Hello,World");
    }
}
