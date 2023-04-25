package com.vonlex.be.model;

import jakarta.persistence.*;


@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "year")
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    // Constructors, getters, and setters
    public Book() {

    }

    public Book(Long id, String title, String isbn, Integer year, Author author) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.author = author;
    }

    public Book(String title, String isbn, Integer year, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getYear() {
        return year;
    }

    public Author getAuthor() {
        return author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
