package com.informations24h.informations24h.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthorDto {

    private Long id;
    private String username;
    private String password;
    private String role;
    private boolean enabled;
}
