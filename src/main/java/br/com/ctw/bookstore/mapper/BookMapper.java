package br.com.ctw.bookstore.mapper;

import br.com.ctw.bookstore.dto.BookCreate;
import br.com.ctw.bookstore.dto.BookResponse;
import br.com.ctw.bookstore.dto.BookUpdate;
import br.com.ctw.bookstore.entity.BookEntity;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class BookMapper {

    public BookEntity toEntity (BookCreate create){
        return BookEntity.builder()
                .title(create.title())
                .authors(create.authors())
                .review(create.review())
                .publisher(create.publisher())
                .build();
    }

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

    public BookEntity toUpdate(BookUpdate update, BookEntity entity){
        if (update.title() != null){
            entity.setTitle(update.title());
        }

        return entity;
    }
}
