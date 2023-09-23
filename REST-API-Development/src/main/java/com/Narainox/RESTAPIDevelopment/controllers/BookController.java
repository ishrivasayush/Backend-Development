package com.Narainox.RESTAPIDevelopment.controllers;

import com.Narainox.RESTAPIDevelopment.model.Book;
import com.Narainox.RESTAPIDevelopment.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @Controller
@RestController
public class BookController {
    @Autowired
    BookService bookService;

    // @RequestMapping(value = "/books",method = RequestMethod.GET)
    // @ResponseBody
    @GetMapping("/books")
    public List<Book> getBookHandler()
    {
       return bookService.getAllBook();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookHandler(@PathVariable("bookId") int id)
    {
        return bookService.getBook(id);
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBookHandler(@PathVariable("bookId") int id)
    {
        return bookService.deleteBook(id);
    }

    @PutMapping("/books/{bookId}")
    public Book updateBookHandler(@RequestBody Book book,@PathVariable("bookId") int id)
    {
        return bookService.updateBook(book,id);
    }

    @PostMapping("/books")
    public Book createBookHandler(@RequestBody Book book)
    {
        return bookService.createBook(book);
    }

}
