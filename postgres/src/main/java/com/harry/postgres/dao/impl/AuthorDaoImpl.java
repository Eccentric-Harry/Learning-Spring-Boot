package com.harry.postgres.dao.impl;


import com.harry.postgres.dao.AuthorDao;
import com.harry.postgres.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;

public class AuthorDaoImpl implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update(
                "INSERT INTO authors(ID , NAME, AGE) VALUES (?, ?, ?)",
                author.getId(), author.getName(), author.getAge()
        );
    }
}
