package com.narainox.bookmanager.service.Impl;

import com.narainox.bookmanager.model.Book;
import com.narainox.bookmanager.repository.BookDao;
import com.narainox.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public ResponseEntity<String> createBook(Book book) {
        try {
            bookDao.save(book);
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteBook(Integer bookId) {
        try {
            Optional<Book> book = bookDao.findById(bookId);
            if (book.isPresent()) {
                bookDao.delete(book.get());
                return new ResponseEntity<>("Deleted", HttpStatus.OK);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Book> updateBook(Book book, Integer bookId) {
        try {
            Optional<Book> book1 = bookDao.findById(bookId);
            if (book1.isPresent()) {
                Book book2 = book1.get();
                book2.setAuthor(book.getAuthor());
                book2.setTitle(book.getTitle());
                return new ResponseEntity<>(bookDao.save(book2), HttpStatus.OK);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Book> getBookById(Integer bookId) {
        try {
            Optional<Book> book = bookDao.findById(bookId);
            if (book.isPresent()) {
                return new ResponseEntity<>(book.get(), HttpStatus.FOUND);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }


    @Override
    public ResponseEntity<List<Book>> getBook() {
        try {
            return new ResponseEntity<>(bookDao.findAll(),HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
