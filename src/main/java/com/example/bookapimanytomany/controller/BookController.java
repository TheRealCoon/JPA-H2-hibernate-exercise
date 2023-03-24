package com.example.bookapimanytomany.controller;

import com.example.bookapimanytomany.model.Author;
import com.example.bookapimanytomany.model.BookDTO;
import com.example.bookapimanytomany.repository.AuthorDAO;
import com.example.bookapimanytomany.repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.bookapimanytomany.model.Book;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private BookDAO bookDAO;
    private AuthorDAO authorDAO;

    @Autowired
    public BookController(BookDAO bookDAO, AuthorDAO authorDAO) {
        this.bookDAO = bookDAO;
        this.authorDAO = authorDAO;
    }

    @GetMapping("/books")
    public List<Book> findAllBooks() {
        return bookDAO.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> findBookById(@PathVariable long id) {
        return bookDAO.findById(id);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        List<Author> authors = bookDTO.getAuthorIds()
                .stream().map(aId -> authorDAO.findById(aId).orElse(null)).toList();
        book.setAuthors(authors);
        bookDAO.save(book);
    }
}
