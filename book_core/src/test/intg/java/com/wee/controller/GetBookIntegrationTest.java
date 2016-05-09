package com.wee.controller;

import com.wee.BookIntegrationBaseTest;
import com.wee.repository.BookRepository;
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
                .andExpect(jsonPath("$[0].bookId").value("123456"))
                .andExpect(jsonPath("$[0].name").value(BOOK_NAME))
                .andExpect(jsonPath("$[0].author").value(BOOK_AUTHOR))
                .andExpect(jsonPath("$[0].year").value(BOOK_YEAR))
                .andExpect(jsonPath("$[0].publisher").value(BOOK_PUBLISHER))
                .andExpect(jsonPath("$[0].description").value(BOOK_DESCRIPTION))
                .andExpect(jsonPath("$[0].category").value("IT"))
                .andExpect(jsonPath("$[0].image").value(BOOK_IMAGE))
                .andExpect(jsonPath("$[0].active").value(true));
    }

}