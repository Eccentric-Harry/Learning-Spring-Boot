package com.harry.books;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harry.books.domain.Book;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;

import static org.assertj.core.api.Assertions.assertThat;

public class JacksonTests {
    @Test
    public void testThatObjectMapperCanCreateJsonFromJavaObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Book book = Book.builder()
                .isbn("234567823456")
                .title("The Enigma of Eternity")
                .author("Aria Montgomery")
                .yearPublished("2005")
                .build();

        String result = objectMapper.writeValueAsString(book);
        assertThat(result).isEqualTo("{\"isbn\":\"234567823456\",\"title\":\"The Enigma of Eternity\",\"author\":\"Aria Montgomery\",\"yearPublished\":\"2005\"}");
    }

    @Test
    public void testThatObjectMapperCanCreateJavaObjectFromJson() throws JsonProcessingException {
        Book book = Book.builder()
                .isbn("234567823456")
                .title("The Enigma of Eternity")
                .author("Aria Montgomery")
                .yearPublished("2005")
                .build();
        String json = "{\"isbn\":\"234567823456\",\"title\":\"The Enigma of Eternity\",\"author\":\"Aria Montgomery\",\"yearPublished\":\"2005\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Book result = objectMapper.readValue(json, Book.class);
        assertThat(result).isEqualTo(book);
    }
}
