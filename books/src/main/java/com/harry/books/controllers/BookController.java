package com.harry.books.controllers;

import com.harry.books.domain.Book;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Log
public class BookController {
    @GetMapping(path = "/books")
    public Book retrieveBook(){
        return Book.builder()
                .isbn("234567823456")
                .title("The Enigma of Eternity")
                .author("Aria Montgomery")
                .yearPublished("2005")
                .build();
    }

    @PostMapping(path = "/books")
    public Book createBook(@RequestBody final Book book){
        log.info("Got Book: " + book.toString());
        return book;
    }



}
