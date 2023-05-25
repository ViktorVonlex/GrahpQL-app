package com.vonlex.be.repository;

import com.vonlex.be.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBookByAuthorIsNull();
    List<Book> findBookByPublisherId(Long id);
    List<Book> findBooksByAuthorId(Long id);
    
    //List<Book> findBooksByTitleContainingIgnoreCase(String title);

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE %:#{#title.toLowerCase()}%")
    List<Book> findBooksByTitleContainingIgnoreCase(@Param("title") String title);

}
