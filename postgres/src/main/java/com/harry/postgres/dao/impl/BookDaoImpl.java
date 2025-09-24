package com.harry.postgres.dao.impl;

import com.harry.postgres.dao.BookDao;
import com.harry.postgres.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDaoImpl implements BookDao {

    private JdbcTemplate jdbcTemplate;

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
}
