package com.informations24h.informations24h.repository;

import com.informations24h.informations24h.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
