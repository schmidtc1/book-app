# Book App

## Objective

Website built using Java Spring Boot to display a book dataset: https://www.kaggle.com/datasets/saurabhbagchi/books-dataset

## Overview

### Controllers

Provides mappings for pages (/page/..., /home, etc.)
Currently, there is a mapping for the initial LocalHost page, which sends the user to /page/{1} for page 1 of the book table

### Helpers

The CSVHelper class imports a CSV file into the Book Repository

### Models

Creates a model for the 'books' table, along with Getters and Setters from Lombok
Each Book contains an ISBN primary key, title, author, year published, and publisher

### Repositories

The BookRepository is an interface extending the JpaRepository class, for its CRUD operations and Paging/Sorting operations

### Services

The BookService performs the CRUD operations and Paging/Sorting operations

## HTML/CSS/Thymeleaf

The index.html file is based off of a tutorial To-Do list table using Bootstrap
I intend to remove some functionality of the To-Do list aspect and orient it more as a sorting and filtering table