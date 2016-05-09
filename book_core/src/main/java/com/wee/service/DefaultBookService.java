package com.wee.service;

import com.wee.entity.BookEntity;
import com.wee.model.Book;
import com.wee.repository.BookRepository;
import com.wee.translator.BookTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBookService implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookTranslator bookTranslator;

    @Override
    public List<Book> getBooksByName(String name) {
        List<BookEntity> booksEntity = bookRepository.findByActiveTrueAndName(name);

        return bookTranslator.translateToBooks(booksEntity);
    }

}
