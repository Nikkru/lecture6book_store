package com.example.lecture6book_store.controller;

import com.example.lecture6book_store.model.Book;
import com.example.lecture6book_store.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Optional<Book> book = bookService.findById(id);
        return book.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public Book save(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book updateById(@RequestBody Book updateBook, @PathVariable Long id){
        updateBook.setId(id);
        return bookService.save(updateBook);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }
}
