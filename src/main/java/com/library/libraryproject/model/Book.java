package com.library.libraryproject.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(length = 100)
    private String title;

    @NotNull
    @Column(length = 300)
    private String description;

    @NotNull
    private Date publicationDate;

    @NotNull
    @Column(length = 100)
    private String author;

    @OneToOne(mappedBy = "book")
    @NotNull
    private Hall hall;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;
}
