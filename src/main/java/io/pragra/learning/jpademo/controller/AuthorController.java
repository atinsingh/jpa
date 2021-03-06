package io.pragra.learning.jpademo.controller;

import io.pragra.learning.api.model.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController implements io.pragra.learning.api.AuthorsApi {
    @Override
    public ResponseEntity<Author> addAuthor(@Valid io.pragra.learning.api.model.Author body) {
        return null;
    }

    public ResponseEntity<List<Author>> findPetsByTags() {
        Author author = new Author();
        author.setId(23L);
        author.setName("Harmit");
        author.setCompany("Pragra");
        author.setStatus(Author.StatusEnum.ACTIVE);
        return new ResponseEntity<List<Author>>(Arrays.asList(author), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateAuthor(@Valid Author body) {
        return null;
    }
}
