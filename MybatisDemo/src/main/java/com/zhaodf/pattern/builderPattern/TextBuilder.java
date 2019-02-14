package com.zhaodf.pattern.builderPattern;

public class TextBuilder extends Builder {
    private  StringBuffer buffer = new StringBuffer();

    public void makeTitle(String title) {
        buffer.append("===============================\n");
        buffer.append("【"+title+"】\n");
    }

    public void makeBody(String body) {
        buffer.append(body+"\n");
    }

    public void makeEnd(String end) {
        buffer.append("文档编写完毕，请阅读！\n");
    }

    public String getResult() {
        return null;
    }
}
