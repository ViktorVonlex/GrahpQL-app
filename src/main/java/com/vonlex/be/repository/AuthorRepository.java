package com.vonlex.be.repository;

import com.vonlex.be.model.Author;
import com.vonlex.be.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findAuthorByBooksId(Long bookId);
    Author findAuthorByBooksPublisherId(Long publisherId);
    Author findAuthorByBooksPublisherName(String name);
}
