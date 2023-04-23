package com.vonlex.be.repository;

import com.vonlex.be.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBookByAuthorIsNull();
    List<Book> findBookByPublisher_Id(Long id);
}
