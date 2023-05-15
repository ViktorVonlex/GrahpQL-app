package com.vonlex.be.restControllers;

import com.vonlex.be.model.Book;
import com.vonlex.be.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> allBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/booksByAuthor/{authorId}")
    public List<Book> byAuthorId(@PathVariable Long authorId) {
        return bookRepository.findBooksByAuthorId(authorId);
    }

    @GetMapping("/{id}")
    public Book byId(@PathVariable("id") Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Book not found with id " + id));
    }

    @GetMapping("/woAuthor")
    public List<Book> woAuthor() {
        return bookRepository.findBookByAuthorIsNull();
    }
}
