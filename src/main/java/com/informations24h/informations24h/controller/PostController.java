package com.informations24h.informations24h.controller;

import com.informations24h.informations24h.model.Post;
import com.informations24h.informations24h.repository.PostArchive;
import com.informations24h.informations24h.service.CurrentUserDetails;
import com.informations24h.informations24h.service.PhotoService;
import com.informations24h.informations24h.service.PostService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    @Autowired
    private static final Logger logger = Logger.getLogger(PostController.class);
    @Autowired
    private PostService postService;
    @Autowired
    private PostArchive postArchive;
    @Autowired
    private PhotoService photoService;

    @GetMapping("/new")
    public String newPost(Model model) {
        model.addAttribute("post",new Post());
        return "/post/new";
    }

    @PostMapping("/new")
    @ResponseBody
    public String createPost(@Valid Post post, BindingResult bindingResult, @RequestParam("imageFile") MultipartFile imageFile, Model model, @AuthenticationPrincipal CurrentUserDetails currentUserDetails) {
        if (bindingResult.hasErrors()) {
            return "/post/new";
        } else if (imageFile.getOriginalFilename().isEmpty()) {
            model.addAttribute("emptyPhotoMessage", "Post photo required.");
            return "/post/new";
        }
//        try {
//            postService.save(post);
//        } catch (Exception e) {
////TODO            log.error("Unable to save post", e);
//            e.printStackTrace();
//            return "error";
//        }
//        Photo photo = new Photo();
//        photo.setFileName(post.getPostTitle() + imageFile.getOriginalFilename());
//        photo.setPath("/static/");
//        photo.setPost(post);
//        try {
//            post.setMainPostImage(photo);
//            postService.saveImage(imageFile, photo);
//        } catch (Exception e) {
//            e.printStackTrace();
////TODO            log.error("Error saving photo", e);
//        }
        return postService.convertPostToDto(post).toString();
    }


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
