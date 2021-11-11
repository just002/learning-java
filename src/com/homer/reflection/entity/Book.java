package com.homer.reflection.entity;

import java.time.LocalDate;

public class Book {
    private String name;
    private LocalDate publishDate;
    private String author;

    public Book(){
        //System.out.println("Book()");
    }

    public Book(String name, LocalDate publishDate, String author) {
        this.name = name;
        this.publishDate = publishDate;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public String getAuthor() {
        return author;
    }
}
