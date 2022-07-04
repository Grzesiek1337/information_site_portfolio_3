package com.informations24h.informations24h.service;

import com.informations24h.informations24h.model.Post;

import java.util.List;

public interface IPostService {

    List<Post> listAll();

    void save(Post post);

    Post get(long id);

    void update(Post post);

    void delete(long id);
}
