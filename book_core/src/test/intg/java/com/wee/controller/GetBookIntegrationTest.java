package test.intg.java.com.wee.controller;

import test.intg.java.com.wee.BookIntegrationBaseTest;
import main.java.com.wee.controller.BookController;
import main.java.com.wee.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static java.lang.String.format;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class GetBookIntegrationTest extends BookIntegrationBaseTest {

    @Autowired
    private BookController bookController;

    @Autowired
    private BookRepository bookRepository;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void shouldGetBooksByName() throws Exception {
        bookRepository.save(givenActiveBookEntity(BOOK_ID));
        bookRepository.save(givenInActiveBookEntity(BOOK_ID_1));

        mockMvc.perform(get(format("/books?name=%s", BOOK_NAME)))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value(BOOK_NAME))
                .andExpect(jsonPath("$[0].author").value(BOOK_AUTHOR))
                .andExpect(jsonPath("$[0].year").value(BOOK_YEAR));
    }

}