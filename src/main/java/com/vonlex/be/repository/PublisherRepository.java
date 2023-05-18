package com.vonlex.be.repository;

import com.vonlex.be.DTO.PublisherDTO;
import com.vonlex.be.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Publisher findPublisherByBooksId(Long id);
    List<Publisher> findPublishersByOriginId(Long cityId);

//    @Query("SELECT NEW com.vonlex.be.DTO.PublisherDTO(p.id, p.name, p.location) FROM Publisher p WHERE p.publisherOrigin.id = :cityId")
//    List<PublisherDTO> findPublishersByPublisherOriginId(@Param("cityId") Long cityId);
}
