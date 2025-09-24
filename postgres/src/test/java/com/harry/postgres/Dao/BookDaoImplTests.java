package com.harry.postgres.Dao;


import com.harry.postgres.dao.impl.BookDaoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import com.harry.postgres.domain.Book;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql(){
        Book book = Book.builder()
                .isbn("978-3-16-148410-0")
                .title("The Great Adventure")
                .authorId(1L)
                .build();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books(ISBN , TITLE, AUTHOR_ID) VALUES (?, ?, ?)"),
                eq("978-3-16-148410-0"),eq("The Great Adventure"),eq(1L)
        );
    }

}
