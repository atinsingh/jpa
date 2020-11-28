package io.pragra.learning.jpademo.controller;

import io.pragra.learning.jpademo.domain.Book;
import io.pragra.learning.jpademo.exceptions.BookNotFoundException;
import io.pragra.learning.jpademo.repo.BookRepo;
import io.pragra.learning.jpademo.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // api/book/
    @GetMapping()
    public List<Book> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return service.getBookById(id);
    }


    @PostMapping()
    public Book createBook(@RequestBody Book book) {
        return service.createBook(book);
    }

    @PutMapping()
    public Book updateBook(@RequestBody Book book) {
        return service.createBook(book);
    }




}
