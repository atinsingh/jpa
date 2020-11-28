package io.pragra.learning.jpademo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Notes")
@Table(name = "table_book")
@Data
@ToString
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;
    private Long isbn;
    @Column(length = 255)
    private String title;

    @OneToOne
    private Author author;

    private String category;

    private double price;

    public Book(Long isbn, String title, Author author, String category, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }
}
