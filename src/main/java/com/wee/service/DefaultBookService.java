package com.wee.service;

import com.wee.entity.BookEntity;
import com.wee.model.Book;
import com.wee.repository.BookRepository;
import com.wee.translator.DefaultBookTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBookService implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    DefaultBookTranslator bookTranslator;

    @Override
    public List<Book> getBooksByName(String name) {
        List<BookEntity> booksEntity = bookRepository.findByName(name);
        return bookTranslator.translateToBooks(booksEntity);
    }

}
