package com.bookDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookDetails.entities.Book;
import com.bookDetails.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooksDetails(){
		return bookService.getAllBooksDetails();
	}

	@GetMapping("/books/{authorName}")
	public List<Book> getAllBookDetailsByAuthor(@PathVariable("authorName") String author){
		return bookService.getBookDetailsByAuthor(author);
	}
	
	@PostMapping("/book")
	public void addBook(@RequestBody Book b) {
		bookService.addBook(b);
	}
	
	@DeleteMapping("/book/{name}")
	public void deleteBookByName(@PathVariable("name") String bookName) {
		bookService.deleteBookByName(bookName);
	}
	
	@PutMapping("/book/{id}")
	public void updateBookById(@PathVariable("id") int bookId, @RequestBody Book b) {
		bookService.updateBookById(b, bookId);
	}
}
