package com.harry.books.services;

import com.harry.books.domain.entity.BookEntity;

public interface BookService {
    BookEntity createBook(String isbn, BookEntity bookEntity);
}
