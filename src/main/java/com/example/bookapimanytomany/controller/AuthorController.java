package com.example.bookapimanytomany.controller;

import com.example.bookapimanytomany.model.Author;
import com.example.bookapimanytomany.repository.AuthorDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    private AuthorDAO authorDAO;

    public AuthorController(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @GetMapping("/authors")
    public List<Author> findAllAuthors(){
        return authorDAO.findAll();
    }

    @GetMapping("/authors/{id}")
    public Optional<Author> findAuthorById(@PathVariable long id){
        return authorDAO.findById(id);
    }

    @PostMapping("/authors")
    public void addAuthor(@RequestBody Author author){
        authorDAO.save(author);
    }
}
