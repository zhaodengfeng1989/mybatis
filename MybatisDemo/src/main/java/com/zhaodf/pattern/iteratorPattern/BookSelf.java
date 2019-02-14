package com.zhaodf.pattern.iteratorPattern;

public class BookSelf implements Aggregate {
    //书架上放的是书的集合
    private Book[] books;
    //目的有二：1.当前位置用来放书 2.++后可用来表示书架上有基本书（集合的下标从0开始）
    private int last = 0;

    //定义构造函数
    public BookSelf(int maxSize){
        this.books = new Book[maxSize];
    }
    //获取某位置的书
    public Book getBookAt(int index){
        return books[index];
    }
    //添加书,每添加一本书,位置向后移一位
    public void appendBook(Book book){
        books[last] = book;
        last ++;
    }
    //书架上书的本数
    public int getLength(){
        return last;
    }

    //实现创造迭代器的iterator方法
    public Iterator iterator() {
        return new BookSelfIterator(this);
    }
}
