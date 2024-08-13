package com.ust.BookService.BookService.service;

import com.ust.BookService.BookService.dto.AuthorDto;
import com.ust.BookService.BookService.feignClient.AuthorFeignClient;
import com.ust.BookService.BookService.model.Book;
import com.ust.BookService.BookService.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorFeignClient authorFeignClient;

    public BookServiceImpl (BookRepository bookRepository,AuthorFeignClient authorFeignClient){
        this.bookRepository = bookRepository;
        this.authorFeignClient = authorFeignClient;
    }

    @Override
    public Book createABook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not Found"));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public AuthorDto getAuthor(long id){
        return authorFeignClient.getAuthor(id);
    }
}
