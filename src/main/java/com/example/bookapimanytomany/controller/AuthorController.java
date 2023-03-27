package com.example.bookapimanytomany.controller;

import com.example.bookapimanytomany.model.Author;
import com.example.bookapimanytomany.model.AuthorDTO;
import com.example.bookapimanytomany.model.Book;
import com.example.bookapimanytomany.repository.AuthorDAO;
import com.example.bookapimanytomany.repository.BookDAO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    private AuthorDAO authorDAO;
    private BookDAO bookDAO;

    public AuthorController(AuthorDAO authorDAO, BookDAO bookDAO) {
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
    }

    @Operation(
            summary = "gets all authors",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Responds with a list of Author entities."),
                    @ApiResponse(responseCode = "400", description = "Author by the given id not found.")
            }
    )
    @GetMapping("/authors")
    public List<Author> findAllAuthors() {
        return authorDAO.findAll();
    }

    @GetMapping("/authors/{id}")
    public Optional<Author> findAuthorById(@PathVariable long id) {
        return authorDAO.findById(id);
    }

    @PostMapping("/authors")
    public void addAuthor(@RequestBody AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        List<Long> bookIds = authorDTO.getBookIds();
        List<Book> books = new ArrayList<>();
        if (!bookIds.isEmpty()) {
            books = bookDAO.findAllById(authorDTO.getBookIds());
        }
        author.setBooks(books);
        authorDAO.save(author);
    }
}
