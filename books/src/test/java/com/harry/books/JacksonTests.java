//package com.harry.books;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.harry.books.domain.entity.BookEntity;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class JacksonTests {
//    @Test
//    public void testThatObjectMapperCanCreateJsonFromJavaObject() throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        BookEntity bookEntity = BookEntity.builder()
//                .isbn("234567823456")
//                .title("The Enigma of Eternity")
//                .author("Aria Montgomery")
//                .yearPublished("2005")
//                .build();
//
//        String result = objectMapper.writeValueAsString(bookEntity);
//        assertThat(result).isEqualTo("{\"isbn\":\"234567823456\",\"title\":\"The Enigma of Eternity\",\"author\":\"Aria Montgomery\",\"yearPublished\":\"2005\"}");
//    }
//
//    @Test
//    public void testThatObjectMapperCanCreateJavaObjectFromJson() throws JsonProcessingException {
//        BookEntity bookEntity = BookEntity.builder()
//                .isbn("234567823456")
//                .title("The Enigma of Eternity")
//                .author("Aria Montgomery")
//                .yearPublished("2005")
//                .build();
//        String json = "{\"isbn\":\"234567823456\",\"title\":\"The Enigma of Eternity\",\"author\":\"Aria Montgomery\",\"yearPublished\":\"2005\"}";
//        ObjectMapper objectMapper = new ObjectMapper();
//        BookEntity result = objectMapper.readValue(json, BookEntity.class);
//        assertThat(result).isEqualTo(bookEntity);
//    }
//}
