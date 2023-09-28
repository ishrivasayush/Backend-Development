package com.narainox.bookmanager.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String firstName;
    private String lastName;
    private String language;

    @OneToOne(mappedBy = "author")
    private Book book;
}
