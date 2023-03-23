package com.example.bookapimanytomany.controller;

import com.example.bookapimanytomany.repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.example.bookapimanytomany.model.Book;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private BookDAO bookDAO;

    @Autowired
    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping("/books")
    public List<Book> findAllBooks(){
        return bookDAO.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> findBookById(@PathVariable long id){
        return bookDAO.findById(id);
    }
}
