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
@Transactional
public class BookRepositoryImplementationTest {


    private final BookRepository underTest;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookRepositoryImplementationTest(BookRepository underTest, AuthorRepository authorRepository) {
        this.underTest = underTest;
        this.authorRepository = authorRepository;
    }


    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        Author savedAuthor = authorRepository.save(author);
        Book book = Book.builder()
                .isbn("123-456-789")
                .title("Test Book")
                .author(savedAuthor)
                .build();
        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        System.out.println(result);
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        Author savedAuthor = authorRepository.save(author);
        Book bookA = Book.builder()
                .isbn("123-456-789")
                .title("Test Book A")
                .author(savedAuthor)
                .build();
        Book bookB = Book.builder()
                .isbn("987-654-321")
                .title("Test Book B")
                .author(savedAuthor)
                .build();
       underTest.save(bookA);
       underTest.save(bookB);
       List<Book> result = (List<Book>) underTest.findAll();
       System.out.println(result);
       assertThat(result).hasSize(2);
    }


    @Test
    public void testThatBookCanBeUpdatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        Author savedAuthor = authorRepository.save(author);
        Book book = Book.builder()
                .isbn("123-456-789")
                .title("Test Book")
                .author(savedAuthor)
                .build();
        underTest.save(book);
        System.out.println("Book Title before update: " + book.getTitle());
        book.setTitle("New Book Title");
        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        System.out.println("Book Title after update: " + result.get().getTitle());
        assertThat(result).isPresent();
        assertThat(result.get().getTitle()).isEqualTo("New Book Title");
    }
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
