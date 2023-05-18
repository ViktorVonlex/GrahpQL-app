package com.vonlex.be.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "publisherOrigin", cascade = CascadeType.ALL)
    private List<Publisher> publisherList;

    public City() {
    }

    public City(Long id, String name, List<Publisher> publisherList) {
        this.id = id;
        this.name = name;
        this.publisherList = publisherList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long cityId) {
        this.id = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Publisher> getPublisherList() {
        return publisherList;
    }

    public void setPublisherList(List<Publisher> publisherList) {
        this.publisherList = publisherList;
    }
}
