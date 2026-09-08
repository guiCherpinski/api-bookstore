package br.com.ctw.bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Entity
@Table(name = "tb_review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(
            name = "comment",
            nullable = false,
            unique = true
    )
    private String comment;
}
