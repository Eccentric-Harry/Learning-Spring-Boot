package com.harry.postgres.Dao;

import com.harry.postgres.domain.Author;
import com.harry.postgres.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){
    }
    static Author createTestAuthorA() {
        return Author.builder()
                .id(3L)
                .name("user 3")
                .age(28)
                .build();
    }
    static Author createTestAuthorB() {
        return Author.builder()
                .id(4L)
                .name("user 4")
                .age(29)
                .build();
    }
    static Author createTestAuthorC() {
        return Author.builder()
                .id(5L)
                .name("user 5")
                .age(33)
                .build();
    }
    static Author createTestAuthor() {
        return Author.builder()
                .id(0L)
                .name("Harry")
                .age(21)
                .build();
    }


    static Book createTestBook() {
        return Book.builder()
                .isbn("978-3-16-148410-0")
                .title("The Great Adventure")
                .author_Id(1L)
                .build();
    }
}
