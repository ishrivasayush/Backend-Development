package com.Narainox.SpringDataJpa.repository;

import com.Narainox.SpringDataJpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {

    List<User> findByNameAndCity(String name,String city);
}
