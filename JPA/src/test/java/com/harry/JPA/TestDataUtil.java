package com.harry.JPA;

import com.harry.JPA.domain.Author;
import com.harry.JPA.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){
    }
    public static Author createTestAuthorA() {
        return Author.builder()
                .name("SuperMan")
                .age(50)
                .build();
    }
    public static Author createTestAuthorB() {
        return Author.builder()
                .name("user 4")
                .age(29)
                .build();
    }
    public static Author createTestAuthorC() {
        return Author.builder()
                .name("user 5")
                .age(21)
                .build();
    }
    public static Author createTestAuthor() {
        return Author.builder()
                .name("Harry")
                .age(21)
                .build();
    }


    public static Book createTestBook(final Author author) {
        return Book.builder()
                .isbn("978-3-16-148410-0")
                .title("The Great Adventure")
                .author(author)
                .build();
    }
    public static Book createTestBookA(final Author author) {
        return Book.builder()
                .isbn("978-1-23-456789-0")
                .title("Mystery of the Old House")
                .author(author)
                .build();
    }
    public static Book createTestBookB(final Author author) {
        return Book.builder()
                .isbn("978-4-56-789012-0")
                .title("Journey to the Unknown")
                .author(author)
                .build();
    }
    static Book createTestBookC(final Author author) {
        return Book.builder()
                .isbn("978-9-87-654321-0")
                .title("Secrets of the Ancient World")
                .author(author)
                .build();
    }
}
