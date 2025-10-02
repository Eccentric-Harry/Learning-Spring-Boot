//package com.harry.JPA;
//
//import com.harry.postgres.domain.Author;
//import com.harry.postgres.domain.Book;
//
//public final class TestDataUtil {
//    private TestDataUtil(){
//    }
//    static Author createTestAuthorA() {
//        return Author.builder()
//                .id(3L)
//                .name("user 3")
//                .age(28)
//                .build();
//    }
//    static Author createTestAuthorB() {
//        return Author.builder()
//                .id(4L)
//                .name("user 4")
//                .age(29)
//                .build();
//    }
//    static Author createTestAuthorC() {
//        return Author.builder()
//                .id(5L)
//                .name("user 5")
//                .age(33)
//                .build();
//    }
//    static Author createTestAuthor() {
//        return Author.builder()
//                .id(0L)
//                .name("Harry")
//                .age(21)
//                .build();
//    }
//
//
//    static Book createTestBook() {
//        return Book.builder()
//                .isbn("978-3-16-148410-0")
//                .title("The Great Adventure")
//                .author_Id(1L)
//                .build();
//    }
//    static Book createTestBookA() {
//        return Book.builder()
//                .isbn("978-1-23-456789-0")
//                .title("Mystery of the Old House")
//                .author_Id(3L)
//                .build();
//    }
//    static Book createTestBookB() {
//        return Book.builder()
//                .isbn("somerandom")
//                .title("Journey to the Unknown")
//                .author_Id(4L)
//                .build();
//    }
//    static Book createTestBookC() {
//        return Book.builder()
//                .isbn("978-9-87-654321-0")
//                .title("Secrets of the Ancient World")
//                .author_Id(5L)
//                .build();
//    }
//}
