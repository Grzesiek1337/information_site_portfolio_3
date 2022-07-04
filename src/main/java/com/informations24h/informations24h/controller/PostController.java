package com.informations24h.informations24h.controller;

import com.informations24h.informations24h.dto.PostDto;
import com.informations24h.informations24h.model.Post;
import com.informations24h.informations24h.repository.PostArchive;
import com.informations24h.informations24h.service.PostService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    @Autowired
    private static final Logger logger = Logger.getLogger(PostController.class);
    @Autowired
    private PostService postService;
    @Autowired
    private PostArchive postArchive = new PostArchive();

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/all")
    public String getPosts() {
        logger.info("Load all posts at " + LocalDateTime.now());
        return postService.listAll().toString();
    }

    @GetMapping("/archive")
    public String getArchivePosts() {
        return convertToDtoPostList(postArchive.getPosts()).toString();

    }

    public List<PostDto> convertToDtoPostList(List<Post> posts) {
        return posts.stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }

}
