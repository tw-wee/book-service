package com.wee.controller;

import com.wee.exception.BookInvalidException;
import com.wee.model.Book;
import com.wee.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/books")
@Api(value = "Books", description = "Operations with Books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = GET)
    @ApiOperation(value = "Get Books by name")
    public ResponseEntity<List<Book>> getBooksByName(@RequestParam(value = "name") String name) {
        List<Book> books = bookService.getBooksByName(name);
        return new ResponseEntity<>(books, OK);
    }

    @RequestMapping(value = "/{id}", method = GET)
    @ApiOperation(value = "Get Book by id")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(book, OK);
    }

    @RequestMapping(method = POST)
    @ApiOperation(value = "Create a book")
    public ResponseEntity<Book> createBook(@RequestBody @Valid Book book, BindingResult bindingResult) {
        rejectInvalidBook(bindingResult);
        Book savedBook = bookService.createBook(book);
        return new ResponseEntity<Book>(savedBook, CREATED);
    }

    private void rejectInvalidBook(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BookInvalidException("Invalid Book", bindingResult.getFieldErrors());
        }
    }
}
