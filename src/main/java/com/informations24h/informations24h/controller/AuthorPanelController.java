package com.informations24h.informations24h.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorPanelController {

    @GetMapping("/author-panel")
    public String getAuthorPanel() {
        return "author/panel";
    }
}
