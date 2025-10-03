package com.harry.JPA.repositories;

import com.harry.JPA.domain.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Iterable<Author> ageLessThan(int age);

    Iterable<Author> findByNameStartingWith(String prefix);

    @Query("SELECT a from Author a where a.age > :minAge")
    Iterable<Author> findAllAuthorsWithAgeGreaterThan(int minAge);
}
