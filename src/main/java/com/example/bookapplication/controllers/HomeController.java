package com.example.bookapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookapplication.services.BookService;

@Controller
public class HomeController {
    
    @Autowired

    private BookService bookService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("books", bookService.getAll());
        return modelAndView;
    }
}
