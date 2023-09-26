package com.narainox.bookmanager.service;

import com.narainox.bookmanager.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    ResponseEntity<String> createBook(Book book);
    ResponseEntity<String> deleteBook(Integer bookId);
    ResponseEntity<Book> updateBook(Book book,Integer bookId);
    ResponseEntity<Book> getBookById(Integer bookId);
    ResponseEntity<List<Book>> getBook();
}
