package com.ust.AuthorService.AuthorService.service;

import com.ust.AuthorService.AuthorService.model.Author;

import java.util.List;

public interface AuthorService {
    public Author getById(long id);
    public List<Author> getAllAuthors();
    public Author createAuthor(Author author);
}
