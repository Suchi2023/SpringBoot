package com.bookDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookDetails.entities.Book;

import jakarta.transaction.Transactional;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	// Using JPQL and native queries with spring data JPA.
	
	@Query("Select b from Book b")
	public List<Book> getAllBooksDetails();
	
	@Query("Select b from Book b where b.author = :authorName")
	public List<Book> getBookDetailsByAuthor(@Param("authorName") String authorName);
	
	@Query(value = "select * from book", nativeQuery = true)
	public List<Book> getAllBooks();
	
	@Modifying
	@Query("insert into Book(name, author, price) values(:n, :a, :p)")
	@Transactional
	public void saveBook(@Param("n") String name, @Param("a") String author, @Param("p") Double price);
	
	@Modifying
	@Query("delete from Book b where b.name = :n")
	@Transactional
	public void deleteBookByName(@Param("n") String name);
	
	@Modifying
	@Query("update Book b set b.name = :n, b.author = :a, b.price = :p where b.id = :id")
	@Transactional
	public void updateBook(@Param("n") String name, @Param("a") String author, @Param("p") Double price, @Param("id") int id);
	
}
