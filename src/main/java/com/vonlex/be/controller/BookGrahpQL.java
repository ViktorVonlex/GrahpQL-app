package com.vonlex.be.controller;

import com.vonlex.be.errors.AuthorNotFoundException;
import com.vonlex.be.model.Author;
import com.vonlex.be.model.Book;
import com.vonlex.be.repository.AuthorRepository;
import com.vonlex.be.repository.BookRepository;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@ControllerAdvice
@Controller
public class BookGrahpQL {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

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

    @SchemaMapping(typeName = "Query", field = "booksByPublisherId")
    public List<Book> bookByPublisherId(@Argument Long id) {
        return bookRepository.findBookByPublisher_Id(id);
    }

    @MutationMapping
    public Book createBook(
            @Argument(name = "title") String title,
            @Argument(name = "isbn") String isbn,
            @Argument(name = "year") int year,
            @Argument(name = "authorId") Long authorId) throws AuthorNotFoundException {
        Optional<Author> author = authorRepository.findById(authorId);
        if (!author.isPresent()) {
            throw new AuthorNotFoundException("Author not found with provided id");
        } else {
            Book book = new Book(title, isbn, year, author.get());
            return bookRepository.save(book);
        }
    }

}
