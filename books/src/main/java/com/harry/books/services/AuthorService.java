package com.harry.books.services;

import com.harry.books.domain.entity.AuthorEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {

    AuthorEntity createAuthor(AuthorEntity author);
}
