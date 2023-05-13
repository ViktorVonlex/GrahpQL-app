package com.vonlex.be.repository;

import com.vonlex.be.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Publisher findPublisherByBooksId(Long id);
}
