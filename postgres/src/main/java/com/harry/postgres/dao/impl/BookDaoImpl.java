package com.harry.postgres.dao.impl;

import com.harry.postgres.dao.BookDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDaoImpl implements BookDao {

    private JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
