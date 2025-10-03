package com.harry.JPA.repositories;

import com.harry.JPA.TestDataUtil;
import com.harry.JPA.domain.Author;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.annotation.DirtiesContext.MethodMode.BEFORE_METHOD;

@SpringBootTest
@ExtendWith(SpringExtension.class)
//@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

public class AuthorRepositoryIntegrationTest {

    private final AuthorRepository underTest;

    @Autowired
    public AuthorRepositoryIntegrationTest(AuthorRepository underTest) {
        this.underTest = underTest;
    }


    @Transactional
    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get()).isEqualTo(author);
    }


    @Transactional
    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled(){
        Author authorA = TestDataUtil.createTestAuthorA();
        System.out.println("AuthorA: " + authorA);
        underTest.save(authorA);
        Author authorB = TestDataUtil.createTestAuthorB();
        System.out.println("AuthorB: " + authorB);
        underTest.save(authorB);
        Author authorC = TestDataUtil.createTestAuthorC();
        System.out.println( "AuthorC: " + authorC);
        underTest.save(authorC);
        Iterable<Author> result = underTest.findAll();
        assertThat(result).hasSize(3).containsExactlyInAnyOrder(authorA, authorB, authorC);
    }

    @Test
    public void testThatAuthorCanBeUpdated(){
        Author authorA = TestDataUtil.createTestAuthorA();
        System.out.println("AuthorA's Name: " + authorA.getName());
        underTest.save(authorA);
        authorA.setName("Hello World");
        underTest.save(authorA);
        System.out.println("AuthorA's Name: " + authorA.getName());
        Optional<Author> result = underTest.findById(authorA.getId());
        System.out.println(result);
        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo("Hello World");
    }

    @Test
    public void testThatAuthorCanBeDeleted(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.save(author);
        underTest.deleteById(author.getId());
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isEmpty();
    }
}
