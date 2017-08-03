package com.thinkgem.jeesite.modules.sms.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 图书Entity
 * @author Gaowang
 * @version 2017-08-01
 */

public class Book extends DataEntity<Book> {

    private static final long serialVersionUID = 1L;
    private String name;    //书籍名称
    private String author;  //书籍作者

    public Book() {
        super();
    }

    public Book(String id) {
        super(id);
    }

    public Book(String name, String author) {
        super();
        this.name = name;
        this.author = author;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
