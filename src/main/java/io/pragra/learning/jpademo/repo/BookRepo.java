package io.pragra.learning.jpademo.repo;

import io.pragra.learning.jpademo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findByPriceOrderByIsbn(double price);

    @Query(value = "select  count(*) from table_book", nativeQuery = true)
    long countAll();

    @Query(value = "select a.* from TABLE_BOOK a, TABLE_AUTHORS b WHERE  a.author_id =  b.id AND b.name= :name", nativeQuery = true)
    List<Book> iamFeelingLucky(@Param("name") String name);
}
