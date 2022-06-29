package com.informations24h.informations24h.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
public class StandardRestController {

    private static final Logger logger = Logger.getLogger(StandardRestController.class);

    @GetMapping("/getAuthor")
    public String getAuthor() {
        logger.info("Getting author at " + LocalDateTime.now());
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