package com.harry.books.services.impl;

import com.harry.books.domain.entity.BookEntity;
import com.harry.books.repositories.BookRepository;
import com.harry.books.services.BookService;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(String isbn, BookEntity bookEntity) {
        bookEntity.setIsbn(isbn);
        return bookRepository.save(bookEntity);
    }

    @Override
    public List<BookEntity> findAll(){
        return StreamSupport.stream(
                bookRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
