package com.ust.BookService.BookService.dto;

import jakarta.validation.constraints.NotEmpty;

public record BookDto(long bookId,
                      @NotEmpty(message = "Book title can't be null")
                      String bookTitle,
                      long authorId,
                      String authorName
                      ) { }
