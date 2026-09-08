package br.com.ctw.bookstore.service;

import br.com.ctw.bookstore.dto.BookResponse;
import br.com.ctw.bookstore.entity.BookEntity;
import br.com.ctw.bookstore.mapper.BookMapper;
import br.com.ctw.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookService {

    private final BookRepository repository;
    private final BookMapper mapper;

    public BookService(BookRepository repository, BookMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<BookResponse> findAllBooks() {
        List<BookEntity> entitys = repository.findAll();
        List<BookResponse> response = mapper.toResponseList(entitys);
        return response;
    }

    public BookResponse findById(UUID id) {
        BookEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("id não encontrado"));
        BookResponse response = mapper.toResponse(entity);
        return response;
    }

    public BookResponse findByTitle(String title){
        BookEntity entity = repository.findByTitle(title);
        BookResponse response = mapper.toResponse(entity);
        return response;
    }

    public void deleteById(UUID id){
        repository.deleteById(id);
    }
}
