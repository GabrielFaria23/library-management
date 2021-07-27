package com.library.libraryproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @NotNull
    @Column(length = 100)
    private String author;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;

    @NotNull
    private boolean available;

    @NotNull
    private Integer quantity;

    @NotNull
    @Column(name = "sale_price")
    private Float salePrice;

    @NotNull
    private boolean rented;

    @NotNull
    @Column(name = "rent_price")
    private Float rentPrice;

    @NotNull
    @Column(name = "date_deliver_book")
    private LocalDateTime dateDeliverBook;
}
