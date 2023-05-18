package com.vonlex.be.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<Book> books;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City publisherOrigin;

    // constructors, getters and setters

    // getter and setter methods
    public Publisher() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Book> getBooks() {
        return books;
    }
}