package com.informations24h.informations24h.service;

import com.informations24h.informations24h.dto.PostDto;
import com.informations24h.informations24h.model.Post;
import com.informations24h.informations24h.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService implements IPostService {

    @Autowired
    private final PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Post> listAll() {
        return postRepository.findAll();
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public Post get(long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void update(Post post) {
        postRepository.save(post);

    }

    @Override
    public void delete(long id) {
    postRepository.deleteById(id);
    }

    public List<PostDto> convertPostListToDto(List<Post> posts) {
        return posts.stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }
}
