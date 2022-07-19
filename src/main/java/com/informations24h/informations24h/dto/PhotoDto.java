package com.informations24h.informations24h.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PhotoDto {

    private Long photoId;
    private String path;
    private String fileName;
    private PostDto post;
}
