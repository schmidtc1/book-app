package com.example.bookapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookapplication.models.Book;
import com.example.bookapplication.services.BookService;

@Controller
public class HomeController {
    
    @Autowired

    private BookService bookService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        bookService.save();
        // modelAndView.addObject("books", bookService.getAll());
        return findPaginated(1);
    }

    @GetMapping("/page/{pageNo}")
    public ModelAndView findPaginated(@PathVariable (value = "pageNo") int pageNo) {
        int pageSize = 5;
        
        Page<Book> page = bookService.findPaginated(pageNo, pageSize);
        List<Book> listBooks = page.getContent();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("currentPage", pageNo);
        modelAndView.addObject("totalPages", page.getTotalPages());
        modelAndView.addObject("totalItems", page.getTotalElements());

        modelAndView.addObject("listBooks", listBooks);
        return modelAndView;
    }
}
