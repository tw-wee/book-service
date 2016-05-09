package com.wee.service;

import com.wee.entity.BookEntity;
import com.wee.exception.BookNotFoundException;
import com.wee.model.Book;
import com.wee.repository.BookRepository;
import com.wee.translator.BookTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;
import static org.springframework.util.StringUtils.isEmpty;

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

    @Override
    public Book getBookById(String bookId) {
        BookEntity bookEntity = bookRepository.findByActiveTrueAndBookId(new Long(bookId));

        if (isEmpty(bookEntity)) {
            throw new BookNotFoundException(format("Book not found for %s", bookId));
        }

        return bookTranslator.translateToBook(bookEntity);
    }

}
