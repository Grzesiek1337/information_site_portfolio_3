package com.informations24h.informations24h.service;

import com.informations24h.informations24h.dto.AuthorDto;
import com.informations24h.informations24h.model.Author;
import com.informations24h.informations24h.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Author> listAll() {
        return authorRepository.findAll();
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Author get(long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public void update(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void delete(long id) {
        authorRepository.deleteById(id);
    }

    public void encodePasswordSetEnableAndSave(Author author) {
        author.setPassword(bCryptPasswordEncoder.encode(author.getPassword()));
        author.setEnabled(true);
        authorRepository.save(author);
    }

    public AuthorDto convertAuthorToDto(Author author) {
        return modelMapper.map(author, AuthorDto.class);
    }

    public Author convertAuthorDtoToEntity(AuthorDto authorDto) {
        return modelMapper.map(authorDto, Author.class);
    }
}