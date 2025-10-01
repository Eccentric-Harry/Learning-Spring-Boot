package com.harry.postgres.Dao;

import com.harry.postgres.config.TestDatabaseConfig;
import com.harry.postgres.dao.impl.AuthorDaoImpl;
import com.harry.postgres.dao.impl.BookDaoImpl;
import com.harry.postgres.domain.Author;
import com.harry.postgres.domain.Book;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Import(TestDatabaseConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookDaoImplIntegrationTests {

    private AuthorDaoImpl authorDaoImpl;

    private BookDaoImpl underTest;
    @Autowired
    private BookDaoImpl bookDaoImpl;

    @Autowired
    public BookDaoImplIntegrationTests(BookDaoImpl underTest, AuthorDaoImpl authorDaoImpl) {
        this.underTest = underTest;
        this.authorDaoImpl = authorDaoImpl;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        authorDaoImpl.create(author);
        Book book = TestDataUtil.createTestBook();
        book.setAuthor_Id(author.getId());
        underTest.create(book);
        Optional<Book> result = underTest.findByIsbn(book.getIsbn());
        assert(result.isPresent());
        assert(result.get().equals(book));
    }
    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled(){
        Author authorA = TestDataUtil.createTestAuthorA();
        authorDaoImpl.create(authorA);
        Author authorB = TestDataUtil.createTestAuthorB();
        authorDaoImpl.create(authorB);
        Book bookA = TestDataUtil.createTestBookA();
        bookDaoImpl.create(bookA);
        bookA.setAuthor_Id(authorA.getId());
        Book bookB = TestDataUtil.createTestBookB();
        bookDaoImpl.create(bookB);
        bookB.setAuthor_Id(authorA.getId());
        List<Book> result = underTest.find();
        System.out.println(result);
        assertThat(result).hasSize(2);
    }
}
