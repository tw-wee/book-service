package com.wee;

import com.wee.entity.BookEntity;
import com.wee.model.Book;

public class BookUnitBaseTest {

    protected static final String BOOK_NAME = "Head First Java";
    protected static final Long BOOK_ID = 123456L;
    protected static final Long BOOK_ID_1 = 654321L;
    protected static final String BOOK_AUTHOR = "Bert Bates";
    protected static final String BOOK_AUTHOR_1 = "Paul Barry";
    protected static final String BOOK_YEAR = "2003";
    protected static final String BOOK_YEAR_1 = "2010";

    protected BookEntity givenActiveBookEntity(Long bookId) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookId(bookId);
        bookEntity.setName(BOOK_NAME);
        bookEntity.setAuthor(BOOK_AUTHOR);
        bookEntity.setYear(BOOK_YEAR);
        bookEntity.setActive(true);
        return bookEntity;
    }

    protected BookEntity givenInActiveBookEntity(Long bookId) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookId(bookId);
        bookEntity.setName(BOOK_NAME);
        bookEntity.setAuthor(BOOK_AUTHOR_1);
        bookEntity.setYear(BOOK_YEAR_1);
        bookEntity.setActive(false);
        return bookEntity;
    }

    protected Book givenActiveBook(Long bookId) {
        Book book = new Book();
        book.setBookId(bookId);
        book.setName(BOOK_NAME);
        book.setAuthor(BOOK_AUTHOR);
        book.setYear(BOOK_YEAR);
        book.setActive(true);
        return book;
    }

    protected Book givenInActiveBook(Long bookId) {
        Book book = new Book();
        book.setBookId(bookId);
        book.setName(BOOK_NAME);
        book.setAuthor(BOOK_AUTHOR_1);
        book.setYear(BOOK_YEAR_1);
        book.setActive(false);
        return book;
    }
}
