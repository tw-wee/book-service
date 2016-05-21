package com.wee.service;

import com.wee.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooksByName(String name);

    Book getBookById(String id);

    Book createBook(Book book);
}
