package com.vonlex.be.controller;

import com.vonlex.be.model.Author;
import com.vonlex.be.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/{id}")
    public Author getAuthorByBookId(@PathVariable Long id){
        return authorRepository.findAuthorByBooksId(id);
    }

    @GetMapping("/byPublisherId/{id}")
    public Author getAuthorByBookPublisherId(@PathVariable Long id){
        return authorRepository.findAuthorByBooksPublisherId(id);
    }

    @GetMapping("/byPublisherName/{publisherName}")
    public Author getAuthorByBookPublisherId(@PathVariable String publisherName){
        return authorRepository.findAuthorByBooksPublisherName(publisherName);
    }
}
