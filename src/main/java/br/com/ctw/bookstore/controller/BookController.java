package br.com.ctw.bookstore.controller;

import br.com.ctw.bookstore.dto.BookCreate;
import br.com.ctw.bookstore.dto.BookResponse;
import br.com.ctw.bookstore.dto.BookUpdate;
import br.com.ctw.bookstore.entity.BookEntity;
import br.com.ctw.bookstore.service.BookService;

import java.awt.print.Book;
import java.util.*;

import org.apache.coyote.Response;
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

    @PostMapping()
    public ResponseEntity<BookResponse> insertBook(@RequestBody BookCreate create){
        return ResponseEntity.ok(service.insertBook(create));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@RequestBody BookUpdate update, @PathVariable UUID id){
        return ResponseEntity.ok(service.updateBook(update,id));
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id){
        service.deleteById(id);
    }
}
