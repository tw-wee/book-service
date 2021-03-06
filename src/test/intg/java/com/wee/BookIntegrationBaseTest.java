package com.wee;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wee.entity.BookEntity;
import com.wee.model.Book;
import com.wee.repository.BookRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static com.wee.model.Category.IT;
import static com.wee.model.Category.MATH;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = BookApiApplication.class)
@PropertySources(value={
        @PropertySource("classpath:environment.properties"),
        @PropertySource("classpath:application.properties")
})
@ActiveProfiles("local")
@Transactional
@TransactionConfiguration
public abstract class BookIntegrationBaseTest {

    protected static final String BOOK_NAME = "Head First Java";
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

    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    protected Long insertActiveBookEntity() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(BOOK_NAME);
        bookEntity.setAuthor(BOOK_AUTHOR);
        bookEntity.setYear(BOOK_YEAR);
        bookEntity.setPublisher(BOOK_PUBLISHER);
        bookEntity.setDescription(BOOK_DESCRIPTION);
        bookEntity.setCategory(IT);
        bookEntity.setImage(BOOK_IMAGE);
        bookEntity.setActive(true);
        return bookRepository.save(bookEntity).getBookId();
    }

    protected Long insertInActiveBookEntity() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(BOOK_NAME);
        bookEntity.setAuthor(BOOK_AUTHOR_1);
        bookEntity.setYear(BOOK_YEAR_1);
        bookEntity.setPublisher(BOOK_PUBLISHER_1);
        bookEntity.setDescription(BOOK_DESCRIPTION_1);
        bookEntity.setCategory(MATH);
        bookEntity.setImage(BOOK_IMAGE_1);
        bookEntity.setActive(false);
        return bookRepository.save(bookEntity).getBookId();
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
        return book;
    }

    protected String toJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

}
