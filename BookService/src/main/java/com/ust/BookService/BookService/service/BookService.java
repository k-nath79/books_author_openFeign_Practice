package com.ust.BookService.BookService.service;

import com.ust.BookService.BookService.model.Book;

import java.util.List;

public interface BookService {
    public Book createABook(Book book);
    public Book getBookById(long id);
    public List<Book> getAllBooks();

}
