package com.ust.BookService.BookService.feignClient;

import com.ust.BookService.BookService.dto.AuthorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "authorService",url = "http://localhost:8080/api/author")
public interface AuthorFeignClient {
    @GetMapping("/{id}")
    AuthorDto getAuthor(@PathVariable long id);
}
