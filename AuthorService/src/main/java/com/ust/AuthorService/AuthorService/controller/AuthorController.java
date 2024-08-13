package com.ust.AuthorService.AuthorService.controller;

import com.ust.AuthorService.AuthorService.dto.AuthorDto;
import com.ust.AuthorService.AuthorService.model.Author;
import com.ust.AuthorService.AuthorService.service.AuthorService;
import com.ust.AuthorService.AuthorService.service.AuthorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService){
        this.authorService = authorService;
    }
    @PostMapping
    public Author createAuthor(@RequestBody @Valid AuthorDto dto){
        Author author = new Author();
        author.setAuthorId(dto.authorId());
        author.setAuthorName(dto.authorName());
        return authorService.createAuthor(author);

    }

    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable long id){
       Author author =  authorService.getById(id);
       AuthorDto dto = new AuthorDto(author.getAuthorId(),author.getAuthorName());
       return dto;
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors = authorService.getAllAuthors();
        return ResponseEntity.status(HttpStatus.FOUND).body(List.copyOf(authors));
    }


}
