package com.informations24h.informations24h.service;

import com.informations24h.informations24h.model.Author;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class CurrentUserDetails implements UserDetails {

    private Author author;

    public CurrentUserDetails(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(author.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return author.getPassword();
    }

    @Override
    public String getUsername() {
        return author.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
