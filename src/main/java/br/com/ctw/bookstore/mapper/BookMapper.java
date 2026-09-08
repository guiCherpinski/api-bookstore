package br.com.ctw.bookstore.mapper;

import br.com.ctw.bookstore.dto.BookResponse;
import br.com.ctw.bookstore.entity.BookEntity;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class BookMapper {

    public BookResponse toResponse(BookEntity entity){
        return new BookResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getAuthors(),
                entity.getReview(),
                entity.getPublisher()
        );
    }

    public List<BookResponse> toResponseList (List<BookEntity> entitys) {
        return entitys.stream().map(this::toResponse).toList();
    }
}
