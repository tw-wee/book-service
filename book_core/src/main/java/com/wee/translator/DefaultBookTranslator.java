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
        book.setBookId(bookEntity.getBookId());
        book.setName(bookEntity.getName());
        book.setAuthor(bookEntity.getAuthor());
        book.setYear(bookEntity.getYear());
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
}
