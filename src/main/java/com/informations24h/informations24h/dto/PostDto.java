package com.informations24h.informations24h.dto;

import com.informations24h.informations24h.model.Author;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class PostDto {

    private Long id;
    private String postTitle;
    private String postContent;
    private AuthorDto postAuthor;
    private LocalDate postCreated;
    private LocalDate postUpdated;

}
