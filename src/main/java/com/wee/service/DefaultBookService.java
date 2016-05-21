package com.wee.service;

import com.wee.entity.BookEntity;
import com.wee.exception.BookAlreadyExistException;
import com.wee.exception.BookNotFoundException;
import com.wee.mapper.BookMapper;
import com.wee.model.Book;
import com.wee.repository.BookRepository;
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
    private BookMapper mapper;

    @Override
    public List<Book> getBooksByName(String name) {
        List<BookEntity> booksEntity = bookRepository.findByActiveTrueAndName(name);

        return mapper.mapList(booksEntity, Book.class);
    }

    @Override
    public Book getBookById(String bookId) {
        BookEntity bookEntity = bookRepository.findByActiveTrueAndBookId(new Long(bookId));

        if (isEmpty(bookEntity)) {
            throw new BookNotFoundException(format("Book not found for BookId %s", bookId));
        }

        return mapper.map(bookEntity, Book.class);
    }

    @Override
    public Book createBook(Book book) {
        rejectDuplicateBook(book);
        BookEntity bookEntity = mapper.map(book, BookEntity.class).setActive(true);
        BookEntity savedBookEntity = bookRepository.save(bookEntity);
        return mapper.map(savedBookEntity, Book.class);
    }

    private void rejectDuplicateBook(Book book) {
        List<BookEntity> booksEntity = bookRepository.findByActiveTrueAndName(book.getName());

        for (BookEntity bookEntity : booksEntity) {
            if (isSameBook(book, bookEntity)) {
                throw new BookAlreadyExistException(format("Book already exist for BookId %s", bookEntity.getBookId()));
            }
        }
    }

    private boolean isSameBook(Book book, BookEntity bookEntity) {
        return bookEntity.getAuthor().equalsIgnoreCase(book.getAuthor())
                && bookEntity.getYear().equalsIgnoreCase(book.getYear());
    }

}
