package com.example.bookManagementSystem.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookManagementSystem.entities.Book;
import com.example.bookManagementSystem.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	// Get all the books
	public List<Book> getAllBooks(){
		List<Book> list = (List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	// Get single record by id
	public Book getBookById(int id) {
		Optional<Book> book = null;
		try {
			book = this.bookRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book.get();
	}
	
   // Add a book details
	public Book addBook(Book b) {
		Book result = null;
		try {
			result = this.bookRepository.save(b);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// Delete book record
	public void deleteBook(int bid) {
		this.bookRepository.deleteById(bid);
	}
	
	// Update book record
	public void updateBook(Book book, int bid) {
		 Book result  = getBookById(bid);			
		if(result != null) {
			if(book.getId() == bid) {
				this.bookRepository.save(book);
			}
		}		
	}
}
