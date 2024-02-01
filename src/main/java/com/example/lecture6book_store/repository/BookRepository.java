package com.example.lecture6book_store.repository;

import com.example.lecture6book_store.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
