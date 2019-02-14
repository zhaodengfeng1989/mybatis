package com.zhaodf.pattern.iteratorPattern;

public class TestIteratorPattern {
    public static void main(String[] args){
        //定义书架可放书的本数
        BookSelf bookSelf = new BookSelf(4);
        bookSelf.appendBook(new Book("Spring深度源码解析"));
        bookSelf.appendBook(new Book("高并发多线程程序设计"));
        bookSelf.appendBook(new Book("高高效人士的7个习惯"));
        bookSelf.appendBook(new Book("分布式理论"));
        Iterator it = bookSelf.iterator();
        while(it.hasNext()){
            Book book = (Book)it.next();
            System.out.println(book.getBookName());
        }

    }
}
