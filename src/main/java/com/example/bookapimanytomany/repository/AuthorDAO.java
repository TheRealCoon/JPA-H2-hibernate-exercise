package com.example.bookapimanytomany.repository;

import com.example.bookapimanytomany.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDAO extends JpaRepository<Author, Long> {

}
