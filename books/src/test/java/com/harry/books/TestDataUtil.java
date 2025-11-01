package com.harry.books;

import com.harry.books.domain.dto.AuthorDto;
import com.harry.books.domain.dto.BookDto;
import com.harry.books.domain.entity.AuthorEntity;
import com.harry.books.domain.entity.BookEntity;

public final class TestDataUtil {
    private TestDataUtil() {
    }

    public static AuthorEntity createTestAuthorA() {
        return AuthorEntity.builder()
                .name("SuperMan")
                .age(50)
                .build();
    }

    public static BookEntity createTestBook(AuthorEntity author) {
        return BookEntity.builder()
                .isbn("978-3-16-148410-0")
                .title("The Great Adventure")
                .author(author)
                .build();
    }

    public static BookDto createTestBookA(AuthorDto author) {
        return BookDto.builder()
                .isbn("978-3-16-148410-0")
                .title("The Great Adventure")
                .author(author)
                .build();
    }
}
