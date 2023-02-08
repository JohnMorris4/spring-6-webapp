package com.jemorriswebdesigns.spring6webapp.services;


import com.jemorriswebdesigns.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
