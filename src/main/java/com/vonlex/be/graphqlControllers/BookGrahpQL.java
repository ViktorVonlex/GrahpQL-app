package com.vonlex.be.graphqlControllers;

import com.vonlex.be.errors.AuthorNotFoundException;
import com.vonlex.be.model.Author;
import com.vonlex.be.model.Book;
import com.vonlex.be.model.Publisher;
import com.vonlex.be.repository.AuthorRepository;
import com.vonlex.be.repository.BookRepository;

import com.vonlex.be.repository.PublisherRepository;
import com.vonlex.be.utilClasses.CreateBookInput;
import com.vonlex.be.utilClasses.UpdateBookInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;


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

    @Autowired
    private PublisherRepository publisherRepository;

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
        return bookRepository.findBookByPublisherId(id);
    }

    @MutationMapping
    public Book createBook(@Argument(name = "input") CreateBookInput createBookInput)
            throws AuthorNotFoundException {
        Optional<Author> author = authorRepository.findById(createBookInput.getAuthor());
        if (author.isEmpty()) {
            throw new AuthorNotFoundException("Author not found with provided id");
        } else {
            Book book = new Book();
            book.setAuthor(author.get());
            if (createBookInput.getTitle() != null) {
                book.setTitle(createBookInput.getTitle());
            }

            if (createBookInput.getIsbn() != null) {
                book.setIsbn(createBookInput.getIsbn());
            }

            if (createBookInput.getYear() != 0) {
                book.setYear(createBookInput.getYear());
            }

            if (createBookInput.getPublisher() != null) {
                Optional<Publisher> optionalPublisher = publisherRepository.findById(createBookInput.getPublisher());
                if (optionalPublisher.isEmpty()) {
                    throw new NoSuchElementException("Cannot update book, because publisher was not found");
                }
                book.setPublisher(optionalPublisher.get());
            }
            return bookRepository.save(book);
        }
    }

    @MutationMapping
    public boolean deleteBook(@Argument(name = "id") Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        } else {
            throw new NoSuchElementException("Book not found with id " + id);
        }
    }

    @MutationMapping
    public Book updateBook(
            @Argument(name = "id") Long id,
            @Argument(name = "input") UpdateBookInput input) {
            Optional<Book> optionalBook = bookRepository.findById(id);
            if (optionalBook.isEmpty()) {
                throw new NoSuchElementException("Book not found with id " + id);
            }

            Book bookToUpdate = optionalBook.get();

            if (input.getTitle() != null) {
                bookToUpdate.setTitle(input.getTitle());
            }

            if (input.getIsbn() != null) {
                bookToUpdate.setIsbn(input.getIsbn());
            }

            if (input.getYear() != 0) {
                bookToUpdate.setYear(input.getYear());
            }

            if (input.getAuthor() != null) {

                Optional<Author> optionalAuthor = authorRepository.findById(input.getAuthor());
                if (optionalAuthor.isEmpty()) {
                    throw new AuthorNotFoundException("Cannot update book, because author was not found");
                }

                bookToUpdate.setAuthor(optionalAuthor.get());
            }

            if (input.getPublisher() != null) {
                Optional<Publisher> optionalPublisher = publisherRepository.findById(input.getPublisher());
                if (optionalPublisher.isEmpty()) {
                    throw new NoSuchElementException("Cannot update book, because publisher was not found");
                }

                bookToUpdate.setPublisher(optionalPublisher.get());
            }

            return bookRepository.save(bookToUpdate);
    }

}
