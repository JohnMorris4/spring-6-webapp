package com.jemorriswebdesigns.spring6webapp.services;

import com.jemorriswebdesigns.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
