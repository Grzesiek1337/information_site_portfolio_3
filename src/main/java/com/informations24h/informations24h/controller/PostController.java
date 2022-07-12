package com.informations24h.informations24h.controller;

import com.informations24h.informations24h.repository.PostArchive;
import com.informations24h.informations24h.service.PostService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    @Autowired
    private static final Logger logger = Logger.getLogger(PostController.class);
    @Autowired
    private PostService postService;
    @Autowired
    private PostArchive postArchive;

    @GetMapping("/all")
    public String getPosts() {
        logger.info("Load all posts at " + LocalDateTime.now());
        return postService.convertPostListToDto(postService.listAll()).toString();
    }

    @GetMapping("/archive")
    public String getArchivePosts() {
        logger.info("Load all archive posts at " + LocalDateTime.now());
        return postService.convertPostListToDto(postArchive.getPosts()).toString();
    }
}
