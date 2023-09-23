package com.Narainox.RESTAPIDevelopment.service.BookServiceImpl;

import com.Narainox.RESTAPIDevelopment.model.Book;
import com.Narainox.RESTAPIDevelopment.repository.BookDao;
import com.Narainox.RESTAPIDevelopment.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public Book createBook(Book book) {
        return bookDao.save(book);
    }

    @Override
    public String deleteBook(int bookId) {
        Optional<Book> book = bookDao.findById(bookId);
        if (book.isPresent())
        {
            Book book1 = book.get();
            bookDao.delete(book1);
            return "Book is Deleted";
        }
        return "Book Doesn't exit";
    }

    @Override
    public Book updateBook(Book book, int bookId) {
        Optional<Book> dao = bookDao.findById(bookId);
        if (dao.isPresent())
        {
            Book book1 = dao.get();
            book1.setTitle(book.getTitle());
            book1.setAuthor(book.getAuthor());
            bookDao.save(book1);
            return book1;
        }
        return book;
    }

    @Override
    public Book getBook(int bookId) {
       return bookDao.findById(bookId).get();
    }

    @Override
    public List<Book> getAllBook() {
        return bookDao.findAll();
    }
}
