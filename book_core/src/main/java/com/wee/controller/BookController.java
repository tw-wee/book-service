package com.wee.controller;

import com.wee.model.Book;
import com.wee.service.BookService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Books", description = "Operations with Books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "Get Books by name")
    public List<Book> getBooksByName(@RequestParam("name") String name) {
        return bookService.getBooksByName(name);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "Get Book by id")
    public Book getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }
}
