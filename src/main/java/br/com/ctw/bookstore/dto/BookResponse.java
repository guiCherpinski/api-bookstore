package br.com.ctw.bookstore.dto;
import br.com.ctw.bookstore.entity.AuthorEntity;
import br.com.ctw.bookstore.entity.PublisherEntity;
import br.com.ctw.bookstore.entity.ReviewEntity;

import java.util.*;

public record BookResponse(
        UUID id,
        String title,
        Set<AuthorEntity> authors,
        ReviewEntity review,
        PublisherEntity publisher
) {
}
