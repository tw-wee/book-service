package com.wee;

import com.wee.controller.BookController;
import com.wee.controller.ExceptionHandlingController;
import com.wee.entity.BookEntity;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import java.lang.reflect.Method;

import static com.wee.model.Category.IT;
import static com.wee.model.Category.MATH;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = BookApiApplication.class)
@Transactional
@TransactionConfiguration
public abstract class BookIntegrationBaseTest {

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

    protected MockMvc mockMvc;

    @Autowired
    private BookController bookController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController)
                .setHandlerExceptionResolvers(createExceptionResolver())
                .build();
    }

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


    private ExceptionHandlerExceptionResolver createExceptionResolver() {
        ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
            protected ServletInvocableHandlerMethod getExceptionHandlerMethod(HandlerMethod handlerMethod, Exception exception) {
                Method method = new ExceptionHandlerMethodResolver(ExceptionHandlingController.class).resolveMethod(exception);
                return new ServletInvocableHandlerMethod(new ExceptionHandlingController(), method);
            }
        };
        exceptionResolver.afterPropertiesSet();
        return exceptionResolver;
    }
}
