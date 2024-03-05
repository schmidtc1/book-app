package com.example.bookapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookapplication.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
