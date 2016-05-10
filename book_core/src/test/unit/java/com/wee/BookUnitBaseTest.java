package com.wee;

import com.wee.entity.BookEntity;
import com.wee.model.Book;

import static com.wee.model.Category.IT;
import static com.wee.model.Category.MATH;

public class BookUnitBaseTest {

    protected static final String BOOK_NAME = "Head First Java";
    protected static final Long BOOK_ID = 123456L;
    protected static final Long BOOK_ID_1 = 654321L;
    protected static final String BOOK_AUTHOR = "Bert Bates";
    protected static final String BOOK_AUTHOR_1 = "Paul Barry";
    protected static final String BOOK_YEAR = "2003";
    protected static final String BOOK_YEAR_1 = "2010";
    protected static final String BOOK_PUBLISHER = "Publisher";
    protected static final String BOOK_PUBLISHER_1 = "Publisher 1";
    protected static final String BOOK_DESCRIPTION = "Book Description";
    protected static final String BOOK_DESCRIPTION_1 = "Book Description 1";
    protected static final String BOOK_IMAGE = "/Users/yuzhang/Downloads/images/pic.img";
    protected static final String BOOK_IMAGE_1 = "/Users/yuzhang/Downloads/images/pic1.img";

    protected BookEntity givenActiveBookEntity(Long bookId) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookId(bookId);
        bookEntity.setName(BOOK_NAME);
        bookEntity.setAuthor(BOOK_AUTHOR);
        bookEntity.setYear(BOOK_YEAR);
        bookEntity.setPublisher(BOOK_PUBLISHER);
        bookEntity.setDescription(BOOK_DESCRIPTION);
        bookEntity.setCategory(IT);
        bookEntity.setImage(BOOK_IMAGE);
        bookEntity.setActive(true);
        return bookEntity;
    }

    protected BookEntity givenInActiveBookEntity(Long bookId) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookId(bookId);
        bookEntity.setName(BOOK_NAME);
        bookEntity.setAuthor(BOOK_AUTHOR_1);
        bookEntity.setYear(BOOK_YEAR_1);
        bookEntity.setPublisher(BOOK_PUBLISHER_1);
        bookEntity.setDescription(BOOK_DESCRIPTION_1);
        bookEntity.setCategory(MATH);
        bookEntity.setImage(BOOK_IMAGE_1);
        bookEntity.setActive(false);
        return bookEntity;
    }

    protected Book givenActiveBook() {
        Book book = new Book();
        book.setName(BOOK_NAME);
        book.setAuthor(BOOK_AUTHOR);
        book.setYear(BOOK_YEAR);
        book.setPublisher(BOOK_PUBLISHER);
        book.setDescription(BOOK_DESCRIPTION);
        book.setCategory(IT);
        book.setImage(BOOK_IMAGE);
        book.setActive(true);
        return book;
    }

    protected Book givenInActiveBook() {
        Book book = new Book();
        book.setName(BOOK_NAME);
        book.setAuthor(BOOK_AUTHOR_1);
        book.setYear(BOOK_YEAR_1);
        book.setPublisher(BOOK_PUBLISHER_1);
        book.setDescription(BOOK_DESCRIPTION_1);
        book.setCategory(MATH);
        book.setImage(BOOK_IMAGE_1);
        book.setActive(false);
        return book;
    }
}
