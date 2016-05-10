package com.wee.translator;

import com.wee.entity.BookEntity;
import com.wee.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultBookTranslator implements BookTranslator {

    public Book translateToBook(BookEntity bookEntity) {
        Book book = new Book();
        book.setBookId(bookEntity.getBookId().toString());
        book.setName(bookEntity.getName());
        book.setAuthor(bookEntity.getAuthor());
        book.setYear(bookEntity.getYear());
        book.setPublisher(bookEntity.getPublisher());
        book.setDescription(bookEntity.getDescription());
        book.setCategory(bookEntity.getCategory());
        book.setImage(bookEntity.getImage());
        book.setActive(bookEntity.isActive());
        return book;
    }

    public List<Book> translateToBooks(List<BookEntity> booksEntity) {
        List<Book> books = new ArrayList<>();
        for (BookEntity bookEntity : booksEntity) {
            Book book = translateToBook(bookEntity);
            books.add(book);
        }
        return books;
    }

    @Override
    public BookEntity translateToBookEntity(Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(book.getName());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setYear(book.getYear());
        bookEntity.setPublisher(book.getPublisher());
        bookEntity.setDescription(book.getDescription());
        bookEntity.setCategory(book.getCategory());
        bookEntity.setImage(book.getImage());
        bookEntity.setActive(true);
        return bookEntity;
    }
}
