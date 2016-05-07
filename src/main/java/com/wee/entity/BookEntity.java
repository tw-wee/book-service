package com.wee.entity;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
public class BookEntity {

    @Id
    @GeneratedValue
    @Column(name="BOOK_ID")
    private Long bookId;

    @Column(name="NAME")
    private String name;

    @Column(name="AUTHOR")
    private String author;

    @Column(name="YEAR")
    private String year;

    @Column(name="ACTIVE")
    private boolean active;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
