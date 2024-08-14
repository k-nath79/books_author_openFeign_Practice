package com.ust.BookService.BookService.feignClient;

import com.ust.BookService.BookService.dto.AuthorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "author-service")
public interface AuthorFeignClient {
    @GetMapping("/api/author/{id}")
    AuthorDto getAuthor(@PathVariable long id);
}
