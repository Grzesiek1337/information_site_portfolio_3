package com.informations24h.informations24h.controller;

import com.informations24h.informations24h.service.AuthorService;
import com.informations24h.informations24h.service.CurrentUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
@RequestMapping("/author")
@Controller
public class AuthorPanelController {

    @Autowired
    private AuthorService authorService;


    @ModelAttribute("author")
    public String getAuthorName(@AuthenticationPrincipal CurrentUserDetails currentUserDetails) {
        return currentUserDetails.getAuthor().getUsername();
    }

    @ModelAttribute("localDateTime")
    public LocalDateTime getTime() {
        return LocalDateTime.now();
    }

    @GetMapping("/panel")
    public String getAuthorPanel() {
        return "author/panel";
    }
}
