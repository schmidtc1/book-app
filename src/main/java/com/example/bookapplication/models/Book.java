package com.example.bookapplication.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "published")
    private Integer published;

    @Column(name = "publisher")
    private String publisher;

    /*
     * books.csv contains three more columns for image URLs (three different sizes)
    */

    public Book() {

    }

    public Book(String isbn, String title, String author, Integer published, String publisher) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.published = published;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return String.format("Book{isbn='%s', title='%s', author='%s', published=%d, publisher='%s'}",
        isbn, title, author, published, publisher);
    }
}
