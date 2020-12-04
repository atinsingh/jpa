package io.pragra.learning.jpademo.controller;

import io.pragra.learning.jpademo.domain.Book;
import io.pragra.learning.jpademo.domain.ErrorResponse;
import io.pragra.learning.jpademo.exceptions.BookNotFoundException;
import io.pragra.learning.jpademo.repo.BookRepo;
import io.pragra.learning.jpademo.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Book")
@RequestMapping("/api/book")
public class BookController {

    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // api/book/
    @GetMapping()
    public List<Book> getAll(@RequestParam(value = "price", required = false) Double price) {
        if (price == null) {
            return service.getAll();
        }
        return service.getAllByPrice(price);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return service.getBookById(id);
    }


    @ApiResponses({
            @ApiResponse(code = 201, message = "Creared", response = Book.class),
            @ApiResponse(code = 400, message = "Bad Requesrt", response = ErrorResponse.class)
    })
    @PostMapping()
    public Book createBook(@RequestBody Book book) {
        return service.createBook(book);
    }

    @PutMapping()
    public Book updateBook(@RequestBody Book book) {
        return service.createBook(book);
    }




}
