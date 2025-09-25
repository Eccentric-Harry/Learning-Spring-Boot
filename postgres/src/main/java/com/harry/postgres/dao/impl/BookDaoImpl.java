package com.harry.postgres.dao.impl;

import com.harry.postgres.dao.BookDao;
import com.harry.postgres.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    // Book row mapper to convert database rows to Book objects
    private final RowMapper<Book> bookRowMapper = (rs, rowNum) -> {
        return Book.builder()
                .isbn(rs.getString("ISBN"))
                .title(rs.getString("TITLE"))
                .authorId(rs.getLong("AUTHOR_ID"))
                .build();
    };

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update(
                "INSERT INTO books(ISBN , TITLE, AUTHOR_ID) VALUES (?, ?, ?)",
                book.getIsbn(), book.getTitle(), book.getAuthorId()
        );
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        List<Book> results = jdbcTemplate.query(
                "SELECT * FROM books WHERE ISBN = ?",
                bookRowMapper,
                isbn
        );

        return results.isEmpty() ? Optional.empty() : Optional.of(results.getFirst());
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM books",
                bookRowMapper
        );
    }

    @Override
    public List<Book> findByAuthorId(Long authorId) {
        return jdbcTemplate.query(
                "SELECT * FROM books WHERE AUTHOR_ID = ?",
                bookRowMapper,
                authorId
        );
    }

    @Override
    public List<Book> findByTitleContaining(String titlePart) {
        return jdbcTemplate.query(
                "SELECT * FROM books WHERE TITLE LIKE ?",
                bookRowMapper,
                "%" + titlePart + "%"
        );
    }
}
