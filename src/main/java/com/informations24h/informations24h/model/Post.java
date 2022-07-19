package com.informations24h.informations24h.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "Post title - not empty.")
    @Size(min = 3, max = 60, message = "Post title length is not enough.")
    private String postTitle;

    @NotEmpty(message = "Post content should not be empty.")
    @Size(min = 15, max = 255, message = "Post content length is not enough.")
    private String postContent;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Photo mainPostImage;

    @ManyToOne
    private Author postAuthor;

    private LocalDate postCreated;

    private LocalDate postUpdated;

    public Post(String postTitle, String postContent, LocalDate postCreated) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postCreated = postCreated;
    }
}
