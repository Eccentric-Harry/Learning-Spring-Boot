package com.harry.books.repositories;

import org.springframework.data.repository.CrudRepository;
import com.harry.books.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}
