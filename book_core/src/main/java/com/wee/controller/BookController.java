package com.wee.controller;

import com.wee.model.Book;
import com.wee.service.BookService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@Api(value = "Books", description = "Operations with Books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books/name/{name}", method = GET)
    @ResponseBody
    @ApiOperation(value = "Get Books by name")
    public List<Book> getBooksByName(@PathVariable String name) {
        return bookService.getBooksByName(name);
    }

    @RequestMapping(value = "/books/id/{id}", method = GET)
    @ResponseBody
    @ApiOperation(value = "Get Book by id")
    public Book getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @RequestMapping(value = "/books", method = POST)
    @ResponseBody
    @ResponseStatus(CREATED)
    @ApiOperation(value = "Create a book")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
}
