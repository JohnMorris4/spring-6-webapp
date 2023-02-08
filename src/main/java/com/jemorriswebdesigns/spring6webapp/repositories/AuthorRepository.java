package com.jemorriswebdesigns.spring6webapp.repositories;

import com.jemorriswebdesigns.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
