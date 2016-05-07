package test.unit.java.com.wee.service;

import test.unit.java.com.wee.BookUnitBaseTest;
import main.java.com.wee.entity.BookEntity;
import main.java.com.wee.model.Book;
import main.java.com.wee.repository.BookRepository;
import main.java.com.wee.service.DefaultBookService;
import main.java.com.wee.translator.BookTranslator;
import main.java.com.wee.translator.DefaultBookTranslator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

public class DefaultBookServiceTest extends BookUnitBaseTest {

    @InjectMocks
    private DefaultBookService bookService;

    @Mock
    private BookRepository bookRepository;

    private BookTranslator bookTranslator = new DefaultBookTranslator();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        setField(bookService, "bookTranslator", bookTranslator);
    }

    @Test
    public void shouldGetBooksByName() throws Exception {
        List<BookEntity> booksEntity = asList(givenActiveBookEntity(BOOK_ID), givenInActiveBookEntity(BOOK_ID_1));

        when(bookRepository.findByName(BOOK_NAME)).thenReturn(booksEntity);

        List<Book> bookList = bookService.getBooksByName(BOOK_NAME);

        assertEquals(bookList.size(), 1);
        assertEquals(bookList.get(0).getBookId(), BOOK_ID);
        assertEquals(bookList.get(0).getName(), BOOK_NAME);
        assertEquals(bookList.get(0).getAuthor(), BOOK_AUTHOR);
        assertEquals(bookList.get(0).getYear(), BOOK_YEAR);
        assertEquals(bookList.get(0).isActive(), true);
    }

}