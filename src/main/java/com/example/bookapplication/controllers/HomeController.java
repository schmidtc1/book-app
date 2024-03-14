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
        bookService.save();
        return findPaginated(1);
    }

    @GetMapping("/page/{pageNo}")
    public ModelAndView findPaginated(@PathVariable (value = "pageNo") int pageNo) {
        int pageSize = 5;
        
        Page<Book> page = bookService.findPaginated(pageNo, pageSize);
        List<Book> listBooks = page.getContent();
        ModelAndView modelAndView = new ModelAndView("index");
        
        // https://stackoverflow.com/questions/48940262/pagination-with-spring-boot-and-thymeleaf
        int current = page.getNumber() + 3;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 6, page.getTotalPages());
        modelAndView.addObject("current", current);
        modelAndView.addObject("begin", begin);
        modelAndView.addObject("end", end);

        modelAndView.addObject("currentPage", pageNo);
        modelAndView.addObject("totalPages", page.getTotalPages());
        modelAndView.addObject("totalItems", page.getTotalElements());

        modelAndView.addObject("listBooks", listBooks);
        return modelAndView;
    }
}
