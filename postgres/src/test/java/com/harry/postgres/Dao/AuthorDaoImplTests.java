package com.harry.postgres.Dao;


import com.harry.postgres.dao.impl.AuthorDaoImpl;
import com.harry.postgres.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql(){
        Author author = TestDataUtil.createTestAuthor();

        underTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors(ID , NAME, AGE) VALUES (?, ?, ?)"),
                eq(0L),eq("Harry"),eq(21)
        );
    }

    @Test
    public void testThatReadOneGeneratesCorrectSql(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L)
        );
    }

    @Test
    public void testThatReadAllGeneratesCorrectSql(){
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateAuthorGeneratesCorrectSql(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.update(3L, author);
        verify(jdbcTemplate).update(
                eq("UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?"),
                eq(0L), eq("Harry"), eq(21), eq(3L)
        );
    }

    @Test
    public void testThatDeleteAuthorGeneratesCorrectSql(){
        underTest.delete(2L);
        verify(jdbcTemplate).update(
                eq("DELETE FROM authors WHERE id = ?"),
                eq(2L)
        );
    }
}
