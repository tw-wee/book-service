package test.unit.java.com.wee.translator;

import test.unit.java.com.wee.BookUnitBaseTest;
import main.java.com.wee.model.Book;
import main.java.com.wee.translator.DefaultBookTranslator;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class DefaultBookTranslatorTest extends BookUnitBaseTest {

    private DefaultBookTranslator translator = new DefaultBookTranslator();

    @Test
    public void shouldTranslateBookEntityToBook() throws Exception {
        Book book = translator.translateToBook(givenActiveBookEntity(BOOK_ID));

        assertEquals(book.getBookId(), BOOK_ID);
        assertEquals(book.getName(), BOOK_NAME);
        assertEquals(book.getAuthor(), BOOK_AUTHOR);
        assertEquals(book.getYear(), BOOK_YEAR);
        assertEquals(book.isActive(), true);
    }

    @Test
    public void shouldTranslateBooksEntityToBooks() throws Exception {
        List<Book> bookList = translator.translateToBooks(
                asList(givenActiveBookEntity(BOOK_ID), givenInActiveBookEntity(BOOK_ID_1)));

        assertEquals(bookList.size(), 2);
        assertEquals(bookList.get(0).getBookId(), BOOK_ID);
        assertEquals(bookList.get(0).getName(), BOOK_NAME);
        assertEquals(bookList.get(0).getAuthor(), BOOK_AUTHOR);
        assertEquals(bookList.get(0).getYear(), BOOK_YEAR);
        assertEquals(bookList.get(0).isActive(), true);

        assertEquals(bookList.get(1).getBookId(), BOOK_ID_1);
        assertEquals(bookList.get(1).getName(), BOOK_NAME);
        assertEquals(bookList.get(1).getAuthor(), BOOK_AUTHOR_1);
        assertEquals(bookList.get(1).getYear(), BOOK_YEAR_1);
        assertEquals(bookList.get(1).isActive(), false);
    }
}