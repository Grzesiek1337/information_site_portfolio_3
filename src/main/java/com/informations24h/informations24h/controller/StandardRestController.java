package com.informations24h.informations24h.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
public class StandardRestController {


    @GetMapping("/getAuthor")
    public String getAuthor() {
        return "Grzegorz M";
    }

    @GetMapping("/getDate")
    public LocalDate getDate() {
        return LocalDate.now();
    }

    @GetMapping("/getTime")
    public LocalTime getTime() {
        return LocalTime.now();
    }

}