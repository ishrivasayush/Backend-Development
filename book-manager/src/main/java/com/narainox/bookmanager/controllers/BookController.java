package com.narainox.bookmanager.controllers;

import com.narainox.bookmanager.model.Book;
import com.narainox.bookmanager.repository.BookDao;
import com.narainox.bookmanager.service.BookService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<String> createBookHandler(@RequestBody Book book)
    {
        return bookService.createBook(book);
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<String> deleteBookHandler(@PathVariable Integer bookId)
    {
        return bookService.deleteBook(bookId);
    }

    @GetMapping("/get/{bookId}")
    public ResponseEntity<Book> getBookHandler(@PathVariable Integer bookId)
    {
        return bookService.getBookById(bookId);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<Book> updateBookHandler(@PathVariable Integer bookId,@RequestBody Book book)
    {
        return bookService.updateBook(book,bookId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getBookHandler()
    {
        return bookService.getBook();
    }


}
