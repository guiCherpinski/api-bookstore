package br.com.ctw.bookstore.repository;

import br.com.ctw.bookstore.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {
}
