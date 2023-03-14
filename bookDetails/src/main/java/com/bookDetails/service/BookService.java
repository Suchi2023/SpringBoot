package com.bookDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookDetails.entities.Book;
import com.bookDetails.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooksDetails(){
		 return bookRepository.getAllBooksDetails();
	}
	
	public List<Book> getBookDetailsByAuthor(String authorName){
		return bookRepository.getBookDetailsByAuthor(authorName);
	}

	public List<Book> getAllBooks(){
		return bookRepository.getAllBooks();
	}
	
	public void addBook(Book b) {
		bookRepository.saveBook(b.getName(), b.getAuthor(), b.getPrice());
	}
	
	public void deleteBookByName(String name) {
		bookRepository.deleteBookByName(name);
	}

	public void updateBookById(Book b, int id) {
		bookRepository.updateBook(b.getName(), b.getAuthor(), b.getPrice(), id);
	}
}
