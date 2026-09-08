package br.com.ctw.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "tb_author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(
            name = "name",
            nullable = false,
            unique = true
    )
    private String name;

    @ManyToMany(mappedBy = "authors",fetch = FetchType.LAZY)
    private Set<BookEntity> books = new HashSet<>();
}
