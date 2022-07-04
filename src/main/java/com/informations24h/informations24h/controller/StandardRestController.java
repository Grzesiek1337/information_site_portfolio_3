package com.informations24h.informations24h.controller;

import com.informations24h.informations24h.dto.AuthorDto;
import com.informations24h.informations24h.model.Author;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
public class StandardRestController {

    private static final Logger logger = Logger.getLogger(StandardRestController.class);

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getAuthor")
    public String getAuthor() {
        logger.info("Author checked at " + LocalDateTime.now());
        return convertAuthorToDto(new Author("grzesiek1988","123","ADMIN",true)).toString();
    }

    @GetMapping("/getDate")
    public LocalDate getDate() {
        logger.info("The date has been checked.");
        return LocalDate.now();
    }

    @GetMapping("/getTime")
    public LocalTime getTime() {
        logger.info("The time has been checked.");
        return LocalTime.now();
    }

    public AuthorDto convertAuthorToDto(Author author) {
        return modelMapper.map(author,AuthorDto.class);
    }

}