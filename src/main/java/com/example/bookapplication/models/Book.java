package com.example.bookapplication.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String isbn;

    private String title;

    private String author;

    private Integer published;

    private String publisher;

    /*
     * books.csv contains three more columns for image URLs (three different sizes)
     */

    @Override
    public String toString() {
        return String.format("Book{id=%d, isbn='%s', title='%s', author='%s', published=%d, publisher='%s'}",
        id, isbn, title, author, published, publisher);
    }
}
