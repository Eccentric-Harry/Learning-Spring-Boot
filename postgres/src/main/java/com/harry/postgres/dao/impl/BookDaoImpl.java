package com.harry.postgres.dao.impl;

import com.harry.postgres.dao.BookDao;
import com.harry.postgres.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static javax.management.Query.eq;

@Component
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update(
                "INSERT INTO books(ISBN , TITLE, AUTHOR_ID) VALUES (?, ?, ?)",
                book.getIsbn(), book.getTitle(), book.getAuthor_Id()
        );
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        List<Book> results = jdbcTemplate.query(
                "SELECT ISBN , TITLE, AUTHOR_ID FROM books WHERE ISBN = ? LIMIT 1",
                    new BookRowMapper(), isbn
        );
        return results.isEmpty() ? Optional.empty() : Optional.of(results.getFirst());
    }

    public static class BookRowMapper implements RowMapper<Book>{
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .isbn(rs.getString("ISBN"))
                    .title(rs.getString("Title"))
                    .author_Id(rs.getLong("AUTHOR_ID"))
                    .build();
        }
    }
}
