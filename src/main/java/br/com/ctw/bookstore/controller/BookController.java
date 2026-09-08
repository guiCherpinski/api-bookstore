package br.com.ctw.bookstore.controller;

import br.com.ctw.bookstore.dto.BookResponse;
import br.com.ctw.bookstore.entity.BookEntity;
import br.com.ctw.bookstore.service.BookService;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService service;

    public BookController(BookService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<BookResponse>> findAllBooks() {
        return ResponseEntity.ok(service.findAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable UUID id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/{title}")
    public ResponseEntity<BookResponse> findByTitle(@PathVariable String title){
        return ResponseEntity.ok(service.findByTitle(title));
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id){
        service.deleteById(id);
    }
}
