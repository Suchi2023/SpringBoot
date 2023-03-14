package com.example.bookManagementSystem.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookManagementSystem.entities.Book;
import com.example.bookManagementSystem.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	// Get all the books record handler
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> list = this.bookService.getAllBooks();
		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	// Get Single book record handler
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int bid){
		Book book = null;
		try {
			book = this.bookService.getBookById(bid);
			if(book == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	// Add a book record handler
	@PostMapping("/book")
	public ResponseEntity<Book> addBook(@RequestBody Book b){
		  Book book = null;
		  try {
			  book =   this.bookService.addBook(b);
			  return ResponseEntity.of(Optional.of(book));
		  }catch(Exception e) {
			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		  }
	}
	
	// Delete a book record handler
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int bid){
		try {
			 this.bookService.deleteBook(bid);
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// Update book record handler
	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int bid){
		 try {
			 this.bookService.updateBook(book, bid);			
		 }catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		 }
		 return ResponseEntity.ok().body(book);
	}
}
