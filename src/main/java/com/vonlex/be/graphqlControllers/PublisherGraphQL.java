package com.vonlex.be.graphqlControllers;

import com.vonlex.be.model.Publisher;
import com.vonlex.be.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class PublisherGraphQL {

    @Autowired
    private PublisherRepository publisherRepository;

    @SchemaMapping(typeName = "Query", field = "publisher")
    public Publisher getById(@Argument Long id) {
        return publisherRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No publisher with this id " + id));
    }

    @SchemaMapping(typeName = "Query", field = "publishers")
    public List<Publisher> publishers() {
        return publisherRepository.findAll();
    }

    @SchemaMapping(typeName = "Query", field = "publisherByBookId")
    public Publisher byBookId(@Argument Long id) {
        return publisherRepository.findPublisherByBooksId(id);
    }

}
