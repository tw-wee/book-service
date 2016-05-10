package com.wee.translator;

import com.wee.BookUnitBaseTest;
import com.wee.entity.BookEntity;
import com.wee.model.Book;
import org.junit.Test;

import java.util.List;

import static com.wee.model.Category.IT;
import static com.wee.model.Category.MATH;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class DefaultBookTranslatorTest extends BookUnitBaseTest {

    private DefaultBookTranslator translator = new DefaultBookTranslator();

    @Test
    public void shouldTranslateBookEntityToBook() throws Exception {
        Book book = translator.translateToBook(givenActiveBookEntity(BOOK_ID));

        assertEquals(book.getBookId(), "123456");
        assertEquals(book.getName(), BOOK_NAME);
        assertEquals(book.getAuthor(), BOOK_AUTHOR);
        assertEquals(book.getYear(), BOOK_YEAR);
        assertEquals(book.getPublisher(), BOOK_PUBLISHER);
        assertEquals(book.getDescription(), BOOK_DESCRIPTION);
        assertEquals(book.getCategory(), IT);
        assertEquals(book.getImage(), BOOK_IMAGE);
        assertEquals(book.isActive(), true);
    }

    @Test
    public void shouldTranslateBooksEntityToBooks() throws Exception {
        List<Book> bookList = translator.translateToBooks(
                asList(givenActiveBookEntity(BOOK_ID), givenInActiveBookEntity(BOOK_ID_1)));

        assertEquals(bookList.size(), 2);

        assertEquals(bookList.get(0).getBookId(), "123456");
        assertEquals(bookList.get(0).getName(), BOOK_NAME);
        assertEquals(bookList.get(0).getAuthor(), BOOK_AUTHOR);
        assertEquals(bookList.get(0).getYear(), BOOK_YEAR);
        assertEquals(bookList.get(0).getPublisher(), BOOK_PUBLISHER);
        assertEquals(bookList.get(0).getDescription(), BOOK_DESCRIPTION);
        assertEquals(bookList.get(0).getCategory(), IT);
        assertEquals(bookList.get(0).getImage(), BOOK_IMAGE);
        assertEquals(bookList.get(0).isActive(), true);

        assertEquals(bookList.get(1).getBookId(), "654321");
        assertEquals(bookList.get(1).getName(), BOOK_NAME);
        assertEquals(bookList.get(1).getAuthor(), BOOK_AUTHOR_1);
        assertEquals(bookList.get(1).getYear(), BOOK_YEAR_1);
        assertEquals(bookList.get(1).getPublisher(), BOOK_PUBLISHER_1);
        assertEquals(bookList.get(1).getDescription(), BOOK_DESCRIPTION_1);
        assertEquals(bookList.get(1).getCategory(), MATH);
        assertEquals(bookList.get(1).getImage(), BOOK_IMAGE_1);
        assertEquals(bookList.get(1).isActive(), false);
    }

    @Test
    public void shouldTranslateBookToBookEntity() throws Exception {
        BookEntity bookEntity = translator.translateToBookEntity(givenActiveBook());

        assertEquals(bookEntity.getName(), BOOK_NAME);
        assertEquals(bookEntity.getAuthor(), BOOK_AUTHOR);
        assertEquals(bookEntity.getYear(), BOOK_YEAR);
        assertEquals(bookEntity.getPublisher(), BOOK_PUBLISHER);
        assertEquals(bookEntity.getDescription(), BOOK_DESCRIPTION);
        assertEquals(bookEntity.getCategory(), IT);
        assertEquals(bookEntity.getImage(), BOOK_IMAGE);
        assertEquals(bookEntity.isActive(), true);
    }
}