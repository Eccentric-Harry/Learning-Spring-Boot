package com.harry.books.controllers;

import com.harry.books.domain.entity.BookEntity;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Log
public class BookController {
    @GetMapping(path = "/books")
    public BookEntity retrieveBook(){
        return BookEntity.builder()
                .isbn("234567823456")
                .title("The Enigma of Eternity")
                .author("Aria Montgomery")
                .yearPublished("2005")
                .build();
    }

    @PostMapping(path = "/books")
    public BookEntity createBook(@RequestBody final BookEntity bookEntity){
        log.info("Got Book: " + bookEntity.toString());
        return bookEntity;
    }



}
