package com.wee.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@ApiModel
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Book {

    private String bookId;

    @ApiModelProperty(required = true)
    @NotNull
    private String name;

    @ApiModelProperty(required = true)
    @NotNull
    private String author;

    @ApiModelProperty(required = true)
    @NotNull
    private String year;

    @ApiModelProperty
    private String publisher;

    @ApiModelProperty
    @Length(max = 200)
    private String description;

    @ApiModelProperty(required = true)
    @NotNull
    private Category category;

    @ApiModelProperty
    private String image;

    private boolean active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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
