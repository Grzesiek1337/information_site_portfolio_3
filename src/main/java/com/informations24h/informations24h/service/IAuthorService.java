package com.informations24h.informations24h.service;

import com.informations24h.informations24h.model.Author;
import com.informations24h.informations24h.model.Post;

import java.util.List;

public interface IAuthorService {

    List<Author> listAll();

    void save(Author author);

    Author get(long id);

    void update(Author author);

    void delete(long id);
}
