package com.wee.controller;

import com.wee.model.Book;
import com.wee.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getBooksByName(@RequestParam("name") String name) {
        return bookService.getBooksByName(name);
    }
}
