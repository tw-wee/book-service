package com.wee.translator;

import com.wee.entity.BookEntity;
import com.wee.model.Book;

import java.util.List;

public interface BookTranslator {
    Book translateToBook(BookEntity bookEntity);
    List<Book> translateToBooks(List<BookEntity> booksEntity);
    BookEntity translateToBookEntity(Book book);
}
