package io.pragra.learning.jpademo;

import io.pragra.learning.jpademo.domain.Author;
import io.pragra.learning.jpademo.domain.Book;
import io.pragra.learning.jpademo.domain.StatusEnum;
import io.pragra.learning.jpademo.repo.AuthRepo;
import io.pragra.learning.jpademo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpademoApplication {
    @Autowired
    private BookRepo repo;

    @Autowired
    private AuthRepo authRepo;

    public static void main(String[] args) {
        SpringApplication.run(JpademoApplication.class, args);
    }

    @Bean
    CommandLineRunner  runner(){
        return args -> {

            Author aut1 = new Author("JohnDoe","Abc Corp",null,new Date(), new Date(), StatusEnum.ACTIVE);
            Author aut2 = new Author("Jean Doe","Abc Corp",null,new Date(), new Date(), StatusEnum.ACTIVE);
            Author aut3 = new Author("Adam","Abc Corp",null,new Date(), new Date(), StatusEnum.ACTIVE);
            Author aut4 = new Author("Harmet","Abc Corp",null,new Date(), new Date(), StatusEnum.ACTIVE);
            Author aut5 = new Author("Ritesh","Edmonton Corp",null,new Date(), new Date(), StatusEnum.ACTIVE);
            aut1 = authRepo.save(aut1);
            aut2 = authRepo.save(aut2);
            aut3 = authRepo.save(aut3);
            aut4 = authRepo.save(aut4);
            authRepo.save(aut5);


            Book book = new Book(110001122L,"Learning Java", aut1,"Programing",300);
            Book book2 = new Book(110001124L,"Learning Angular",aut2,"Programing",200);
            Book save = repo.save(book);
            Book save3 = repo.save(book2);
            repo.save(new Book(110001125L,"Learning React",aut3,"Programing",100));
            repo.save(new Book(110001126L,"Learning Cry in Java",aut4,"Programing",200));
            List<Book> all = repo.findAll();
            repo.findById(2L).ifPresent(System.out::println);


            System.out.println(repo.findByPriceOrderByIsbn(200));

            System.out.println(repo.countAll());

            System.out.println(repo.iamFeelingLucky("Adam"));
        };
    }

}
