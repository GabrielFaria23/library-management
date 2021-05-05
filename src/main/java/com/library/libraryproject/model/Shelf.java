package com.library.libraryproject.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "shelf")
public class Shelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String shelfName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @OneToMany(mappedBy = "shelf")
    private List<Book> books;
}
