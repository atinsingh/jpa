package io.pragra.learning.jpademo.service;

import io.pragra.learning.jpademo.domain.Author;
import io.pragra.learning.jpademo.domain.Book;
import io.pragra.learning.jpademo.exceptions.AuthorNotFoundException;
import io.pragra.learning.jpademo.exceptions.BookNotFoundException;
import io.pragra.learning.jpademo.repo.AuthRepo;
import io.pragra.learning.jpademo.repo.BookRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepo repo;
    private AuthRepo authRepo;

    public BookService(BookRepo repo, AuthRepo authRepo) {
        this.repo = repo;
        this.authRepo = authRepo;
    }

    public Book getBookById(Long id) {
        Optional<Book> byId = this.repo.findById(id);
        if(byId.isPresent()) {
            return byId.get();
        }else {
            throw new BookNotFoundException("Not found any book");
        }

    }

    public List<Book> getAll() {
        return repo.findAll();
    }

    public List<Book> getAllByPrice(double p) {
        return repo.findAllByPrice(p);
    }

    public Book createBook(@RequestBody Book book) {
        Long id = book.getAuthor().getId();
        Optional<Author> author = authRepo.findById(id);
        if(!author.isPresent()) {
           throw new AuthorNotFoundException("Author Doesn't exist");
        }
        book.setAuthor(author.get());
        return repo.save(book);
    }

}
