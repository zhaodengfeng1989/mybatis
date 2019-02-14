package com.zhaodf.pattern.iteratorPattern;

public class BookSelfIterator implements Iterator {
    //在迭代器实现类中组合了书集合类,用于遍历
    private BookSelf bookSelf;
    //迭代器中用于判断执元素位置指向的下标
    private int index;

    public BookSelfIterator(BookSelf bookSelf){
        this.bookSelf = bookSelf;
        this.index = 0;
    }
    public boolean hasNext() {
        if(index<bookSelf.getLength()){
            return true;
        }
        return false;
    }

    public Object next() {
        Book book = bookSelf.getBookAt(index);
        index++;
        return book;
    }
}
