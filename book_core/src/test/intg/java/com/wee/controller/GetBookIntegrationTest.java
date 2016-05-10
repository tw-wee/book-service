package com.wee.controller;

import com.wee.BookIntegrationBaseTest;
import org.junit.Test;

import static java.lang.String.format;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GetBookIntegrationTest extends BookIntegrationBaseTest {

    @Test
    public void shouldGetActiveBooksByName() throws Exception {
        Long bookId = insertActiveBookEntity();

        mockMvc.perform(get(format("/books/name/%s", BOOK_NAME)))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].bookId").value(bookId.toString()))
                .andExpect(jsonPath("$[0].name").value(BOOK_NAME))
                .andExpect(jsonPath("$[0].author").value(BOOK_AUTHOR))
                .andExpect(jsonPath("$[0].year").value(BOOK_YEAR))
                .andExpect(jsonPath("$[0].publisher").value(BOOK_PUBLISHER))
                .andExpect(jsonPath("$[0].description").value(BOOK_DESCRIPTION))
                .andExpect(jsonPath("$[0].category").value("IT"))
                .andExpect(jsonPath("$[0].image").value(BOOK_IMAGE))
                .andExpect(jsonPath("$[0].active").value(true));
    }

    @Test
    public void shouldGetActiveBookById() throws Exception {
        Long bookId = insertActiveBookEntity();

        mockMvc.perform(get(format("/books/id/%s", bookId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(BOOK_NAME))
                .andExpect(jsonPath("$.author").value(BOOK_AUTHOR))
                .andExpect(jsonPath("$.year").value(BOOK_YEAR))
                .andExpect(jsonPath("$.publisher").value(BOOK_PUBLISHER))
                .andExpect(jsonPath("$.description").value(BOOK_DESCRIPTION))
                .andExpect(jsonPath("$.category").value("IT"))
                .andExpect(jsonPath("$.image").value(BOOK_IMAGE))
                .andExpect(jsonPath("$.active").value(true));
    }

    @Test
    public void shouldNotGetInActiveBookById() throws Exception {
        Long bookId = insertInActiveBookEntity();

        mockMvc.perform(get(format("/books/id/%s", bookId)))
                .andExpect(status().isNotFound());
    }

}