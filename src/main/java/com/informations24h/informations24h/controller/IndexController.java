package com.informations24h.informations24h.controller;

import com.informations24h.informations24h.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postService.convertPostListToDto(postService.listAll()));
        return "index";
    }
}
