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

    @OneToMany(mappedBy = "origin", cascade = CascadeType.ALL)
    private List<Publisher> publishers;

    public City() {
    }

    public City(Long id, String name, List<Publisher> publishers) {
        this.id = id;
        this.name = name;
        this.publishers = publishers;
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

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publisherList) {
        this.publishers = publisherList;
    }
}
