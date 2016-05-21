package com.wee.controller;

import com.wee.BookIntegrationBaseTest;
import com.wee.model.Book;
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

    @Test
    public void shouldReturn400GivenEmptyNameForBook() throws Exception {
        Book book = givenActiveBook();
        book.setName("");

        mockMvc.perform(post("/books")
                .content(toJson(book))
                .contentType(MediaType.valueOf("application/json")))
                .andExpect(status().isBadRequest());
    }


    @Test
    public void shouldReturn400GivenBookDescriptionMoreThan200() throws Exception {
        Book book = givenActiveBook();
        book.setDescription("Head First Java delivers a highly interactive, "
                + "multisensory learning experience that lets new programmers pick up"
                + " the fundamentals of the Java language quickly. Through mind-stretching "
                + "exercises, memorable analogies, humorous pictures, and casual language.");

        mockMvc.perform(post("/books")
                .content(toJson(book))
                .contentType(MediaType.valueOf("application/json")))
                .andExpect(status().isBadRequest());
    }
}