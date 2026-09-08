package br.com.ctw.bookstore.controller;

import br.com.ctw.bookstore.dto.BookResponse;
import br.com.ctw.bookstore.entity.BookEntity;
import br.com.ctw.bookstore.service.BookService;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
