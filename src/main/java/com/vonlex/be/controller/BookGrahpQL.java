package com.vonlex.be.controller;

import com.vonlex.be.model.Book;
import com.vonlex.be.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class BookGrahpQL {

    @Autowired
    private BookRepository bookRepository;

    @SchemaMapping(typeName = "Query", field = "books")
    List<Book> books(){
        return bookRepository.findAll();
    }

    @SchemaMapping(typeName = "Query", field = "book")
    Book book(@Argument Long id){
        return bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Book not found with id " + id));
    }

    @SchemaMapping(typeName = "Query", field = "woAuthor")
    public List<Book> woAuthor() {
        return bookRepository.findBookByAuthorIsNull();
    }
}
