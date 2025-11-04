package com.harry.books.services;

import com.harry.books.domain.dto.BookDto;
import com.harry.books.domain.entity.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    BookEntity createBook(String isbn, BookEntity bookEntity);
    List<BookEntity> findAll();
}
