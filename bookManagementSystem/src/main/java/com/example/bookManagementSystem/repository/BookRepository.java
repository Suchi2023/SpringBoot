package com.example.bookManagementSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bookManagementSystem.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

}
