package com.informations24h.informations24h.controller;

import com.informations24h.informations24h.dto.AuthorDto;
import com.informations24h.informations24h.model.Author;
import com.informations24h.informations24h.service.AuthorService;
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
    private AuthorService authorService;
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

    @GetMapping("/createAdmin")
    public String createAdminAuthor() {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setUsername("GrzegorzM");
        authorDto.setPassword("123");
        authorDto.setRole("ROLE_ADMIN");
        authorService.encodePasswordSetEnableAndSave(convertAuthorDtoToEntity(authorDto));
        logger.info("Admin has been created.");
        return "success";
    }

    public AuthorDto convertAuthorToDto(Author author) {
        return modelMapper.map(author,AuthorDto.class);
    }

    public Author convertAuthorDtoToEntity(AuthorDto authorDto) {
        return modelMapper.map(authorDto,Author.class);
    }


}