package com.ust.AuthorService.AuthorService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "author")
@EntityListeners(EnableJpaAuditing.class)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorId;
    private String authorName;
}
