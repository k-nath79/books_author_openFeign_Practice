package com.ust.AuthorService.AuthorService.repository;

import com.ust.AuthorService.AuthorService.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
