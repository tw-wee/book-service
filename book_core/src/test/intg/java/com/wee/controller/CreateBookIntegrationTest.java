package com.wee.controller;

import com.wee.BookIntegrationBaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CreateBookIntegrationTest extends BookIntegrationBaseTest {

    @Test
    public void shouldCreateBookSuccessfully() throws Exception {
        mockMvc.perform(post("/books")
                .content(toJson(givenActiveBook()))
                .contentType(MediaType.valueOf("application/json")))
                .andExpect(status().isCreated())
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
    public void shouldNotCreateDuplicateBook() throws Exception {
        insertActiveBookEntity();

        mockMvc.perform(post("/books")
                .content(toJson(givenActiveBook()))
                .contentType(MediaType.valueOf("application/json")))
                .andExpect(status().isConflict());
    }

}