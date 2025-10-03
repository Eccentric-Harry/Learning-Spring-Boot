package com.harry.JPA.repositories;

import com.harry.JPA.TestDataUtil;
import com.harry.JPA.domain.Author;
import com.harry.JPA.domain.Book;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryImplementationTest {


    private final BookRepository underTest;

    @Autowired
    public BookRepositoryImplementationTest(BookRepository underTest) {
        this.underTest = underTest;
    }

    @Transactional
    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        System.out.println(author);
        Book book = TestDataUtil.createTestBook(author);
        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(book);
    }
//
//    @Test
//    public void testThatMultipleBooksCanBeCreatedAndRecalled(){
//        Author authorA = TestDataUtil.createTestAuthorA();
//        underTest.save(authorA);
//        Author authorB = TestDataUtil.createTestAuthorB();
//        underTest.save(authorB);
//        Book bookA = TestDataUtil.createTestBookA(authorA);
//        underTest.save(bookA);
//        Book bookB = TestDataUtil.createTestBookB(authorB);
//        underTest.save(bookB);
//        Iterable<Book> result = underTest.findAll();
//        System.out.println(result);
//        assertThat(result).hasSize(2);
//    }
//
//    @Test
//    public void testThatBookCanBeUpdatedAndRecalled(){
//        Author authorA = TestDataUtil.createTestAuthorA();
//        authorDaoImpl.create(authorA);
//        Book bookA = TestDataUtil.createTestBookA();
//        bookA.setAuthor_Id(authorA.getId());
//        underTest.create(bookA);
//        bookA.setTitle("UPDATED");
//        underTest.update(bookA);
//        Optional<Book> result = underTest.findByIsbn(bookA.getIsbn());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(bookA);
//    }
//
//    @Test
//    public void testThatBookCanBeDeletedAndRecalled(){
//        Author author = TestDataUtil.createTestAuthor();
//        authorDaoImpl.create(author);
//        Book book = TestDataUtil.createTestBook();
//        book.setAuthor_Id(author.getId());
//        underTest.create(book);
//        underTest.delete(book.getIsbn());
//        Optional<Book> result = underTest.findByIsbn(book.getIsbn());
//        assertThat(result).isNotPresent();
//    }
}
