package com.example.bookapimanytomany.controller;

import com.example.bookapimanytomany.model.Author;
import com.example.bookapimanytomany.model.Book;
import com.example.bookapimanytomany.model.BookDTO;
import com.example.bookapimanytomany.repository.AuthorDAO;
import com.example.bookapimanytomany.repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<Long> authorIds = bookDTO.getAuthorIds();
        List<Author> authors = new ArrayList<>();
        if (!authorIds.isEmpty()) {
            authors = authorDAO.findAllById(authorIds);
        }
        book.setAuthors(authors);
        authors.forEach(a -> a.addBook(book));
        bookDAO.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") long id) {
        Book book = bookDAO.findById(id).orElseThrow();
        book.getAuthors()
                .forEach(author -> {
                    author.getBooks()
                            .removeIf(book1 -> book1.getId() == id);
                    authorDAO.save(author);
                });
        book.setAuthors(null);
        bookDAO.save(book);
        bookDAO.deleteById(id);
    }
}
