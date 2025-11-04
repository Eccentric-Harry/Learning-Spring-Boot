package com.harry.books.controllers;

import com.harry.books.domain.dto.BookDto;
import com.harry.books.domain.entity.BookEntity;
import com.harry.books.mapper.Mapper;
import com.harry.books.services.BookService;
import lombok.extern.java.Log;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@Log
public class BookController {

    private final BookService bookService;

    private final Mapper<BookEntity, BookDto> bookMapper;
    public BookController(BookService bookService, Mapper<BookEntity, BookDto> bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook(@PathVariable String isbn, @RequestBody BookDto bookDto) throws Exception {
        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        BookEntity savedBookEntity = bookService.createBook(isbn, bookEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookMapper.mapTo(savedBookEntity));
    }

    @GetMapping(path = "/books")
    public List<BookDto> getAllBooks() {
        List<BookEntity> books = bookService.findAll();
        return books.stream().map(bookMapper::mapTo).collect(Collectors.toList());
    }
}
