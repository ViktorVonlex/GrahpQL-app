package com.vonlex.be.restControllers;

import com.vonlex.be.model.Publisher;
import com.vonlex.be.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;


    @GetMapping("/publisherByBookId/{bookId}")
    public Publisher byAuthorId(@PathVariable Long bookId) {
        return publisherRepository.findPublisherByBooksId(bookId);
    }
}
