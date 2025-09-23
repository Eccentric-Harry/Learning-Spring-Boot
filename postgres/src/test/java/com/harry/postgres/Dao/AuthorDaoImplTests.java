package com.harry.postgres.Dao;


import com.harry.postgres.dao.impl.AuthorDaoImpl;
import com.harry.postgres.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl authorDao;

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql(){
        Author author = Author.builder()
                .id(1L)
                .name("Eccentric Harry")
                .age(21)
                .build();

        authorDao.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors(ID , NAME, AGE) VALUES (?, ?, ?)"),
                eq(1L),eq("Eccentric Harry"),eq(21)
        );
    }
}
