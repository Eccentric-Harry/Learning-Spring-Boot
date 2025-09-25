package com.harry.postgres.dao;

import com.harry.postgres.domain.Book;
import java.util.List;
import java.util.Optional;

public interface BookDao {

    void create(Book book);

    Optional<Book> findByIsbn(String isbn);

    List<Book> findAll();

    List<Book> findByAuthorId(Long authorId);

    List<Book> findByTitleContaining(String titlePart);
}
