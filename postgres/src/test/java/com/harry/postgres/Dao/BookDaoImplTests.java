package com.harry.postgres.Dao;


import com.harry.postgres.dao.impl.AuthorDaoImpl;
import com.harry.postgres.dao.impl.BookDaoImpl;
import com.harry.postgres.domain.Author;
import com.harry.postgres.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    private AuthorDaoImpl authorDaoImpl;

    public BookDaoImplTests(@Mock AuthorDaoImpl authorDaoImpl) {
        this.authorDaoImpl = authorDaoImpl;
    }

    @Test
    public void testThatCreateBookGeneratesCorrectSql(){
        Book book = TestDataUtil.createTestBook();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books(ISBN , TITLE, AUTHOR_ID) VALUES (?, ?, ?)"),
                eq("978-3-16-148410-0"),eq("The Great Adventure"),eq(1L)
        );
    }

    @Test
    public void testThatFindByIsbnGeneratesCorrectSql(){
        underTest.findByIsbn("978-3-16-148410-0");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("978-3-16-148410-0")
        );
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled(){
//        Author authorA = TestDataUtil.createTestAuthorA();
//        authorDaoImpl.create(authorA);
//        Author authorB = TestDataUtil.createTestAuthorB();
//        authorDaoImpl.create(authorB);
//        Book bookA = TestDataUtil.createTestBookA();
//        bookA.setAuthor_Id(authorA.getId());
//        Book bookB = TestDataUtil.createTestBookB();
//        bookB.setAuthor_Id(authorA.getId());
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
        );
    }

    // what did we learn here is that, the unit tests can run independently of the database
    // by mocking the jdbcTemplate. But for Integration test, the tests on Books need the present of Author with the AuthorId in the Authors table to satisfy the Referential Integrity constraint.
}

