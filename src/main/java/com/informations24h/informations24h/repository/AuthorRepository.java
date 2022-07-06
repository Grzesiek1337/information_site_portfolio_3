package com.informations24h.informations24h.repository;

import com.informations24h.informations24h.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Query("SELECT a FROM Author a WHERE a.username = :username")
    Author getAuthorByUsername(@Param("username") String username);
}
