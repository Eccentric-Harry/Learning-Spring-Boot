package com.harry.books.services;

import com.harry.books.domain.Author;
import com.harry.books.domain.dto.AuthorDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {

    Author createAuthor(AuthorDto author);
}
