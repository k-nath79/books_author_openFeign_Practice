package com.ust.AuthorService.AuthorService.service;

import com.ust.AuthorService.AuthorService.model.Author;
import com.ust.AuthorService.AuthorService.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository=authorRepository;
    }


    @Override
    public Author getById(long id) {
        return authorRepository.findById(id).orElseThrow(()-> new RuntimeException("Author with the ID not Found"));
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author createAuthor(Author author){
        authorRepository.save(author);
        return author;
    }
}
