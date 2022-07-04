package com.informations24h.informations24h.service;

import com.informations24h.informations24h.model.Post;
import com.informations24h.informations24h.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class PostService implements IPostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> listAll() {
        return postRepository.findAll();
    }

    @Override
    public void save(Post post) {

    }

    @Override
    public Post get(long id) {
        return null;
    }

    @Override
    public void update(Post post) {

    }

    @Override
    public void delete(long id) {

    }
}
