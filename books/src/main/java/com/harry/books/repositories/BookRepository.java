package com.harry.books.repositories;

import org.springframework.data.repository.CrudRepository;
import com.harry.books.domain.entity.BookEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> {
}
