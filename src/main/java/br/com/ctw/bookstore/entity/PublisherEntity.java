package br.com.ctw.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;
@Entity
@Table(name = "tb_publisher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(
            nullable = false,
            unique = true,
            name = "name"
    )
    private String name;

    @OneToMany(mappedBy = "publisher" , fetch = FetchType.LAZY)
    private Set<BookEntity> books = new HashSet<>();
}
