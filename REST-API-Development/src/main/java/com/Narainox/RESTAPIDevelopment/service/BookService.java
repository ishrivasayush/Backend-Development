package com.Narainox.RESTAPIDevelopment.service;

import com.Narainox.RESTAPIDevelopment.model.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    String deleteBook(int bookId);
    Book updateBook(Book book, int bookId);
    Book getBook(int bookId);
    List<Book> getAllBook();

}
