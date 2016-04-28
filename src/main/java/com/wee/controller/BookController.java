package com.wee.controller;

import com.wee.model.Book;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public Book getBookByName(@RequestParam("name") String name) {
        return new Book(name);
    }
}
