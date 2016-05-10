package com.wee.entity;

import com.wee.model.Category;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
public class BookEntity {

    @Id
    @GeneratedValue
    @Column(name = "BOOK_ID")
    private Long bookId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Column(name = "YEAR")
    private String year;

    @Column(name = "PUBLISHER")
    private String publisher;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "IMAGE")
    private String image;

    @Type(type = "yes_no")
    @Column(name = "ACTIVE", nullable = false)
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
