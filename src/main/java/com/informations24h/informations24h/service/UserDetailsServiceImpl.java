package com.informations24h.informations24h.service;

import com.informations24h.informations24h.model.Author;
import com.informations24h.informations24h.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Author author = authorRepository.getAuthorByUsername(username);
        if (author == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new CurrentUserDetails(author);
    }
}
