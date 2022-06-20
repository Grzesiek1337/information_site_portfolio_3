package com.informations24h.informations24h.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 0, max = 20)
    private String postTitle;

    @NotBlank
    private String postContent;

    @ManyToOne
    private Author postAuthor;

    private LocalDate postCreated;

    private LocalDate postUpdated;

}
