package com.ust.AuthorService.AuthorService.dto;

import jakarta.validation.constraints.NotEmpty;

public record AuthorDto(long authorId,

                        @NotEmpty(message = "Author name is required")
                        String authorName) {
}
