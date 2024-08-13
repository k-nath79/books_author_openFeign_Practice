package com.ust.BookService.BookService.controller;

import com.ust.BookService.BookService.dto.AuthorDto;
import com.ust.BookService.BookService.dto.BookDto;
import com.ust.BookService.BookService.feignClient.AuthorFeignClient;
import com.ust.BookService.BookService.model.Book;
import com.ust.BookService.BookService.service.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookServiceImpl bookService;
    public BookController(BookServiceImpl bookService,AuthorFeignClient authorFeignClient){
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody @Valid BookDto bookDto){
        Book book = new Book();
        book.setBookTitle(bookDto.bookTitle());
        book.setAuthorId(bookDto.authorId());
        bookService.createABook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookbyId(@PathVariable long id){
        Book book= bookService.getBookById(id);
        long bookId = book.getBookId();
        AuthorDto dto = bookService.getAuthor(bookId);
        BookDto bookDto = new BookDto(book.getBookId(),book.getBookTitle(), dto.authorId(),dto.authorName());


        return ResponseEntity.status(HttpStatus.FOUND).body(bookDto);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.FOUND).body(bookService.getAllBooks());
    }


}
