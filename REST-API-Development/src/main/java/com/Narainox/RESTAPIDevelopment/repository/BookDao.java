package com.Narainox.RESTAPIDevelopment.repository;

import com.Narainox.RESTAPIDevelopment.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book,Integer> {
}
