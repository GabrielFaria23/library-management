package com.library.libraryproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(length = 100)
    private String hall_name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "library_id")
    @NotNull
    private Library library;

    @OneToMany(mappedBy = "hall")
    @JsonIgnore
    @NotNull
    private List<Book> books;

    @OneToMany(mappedBy = "hall")
    @JsonIgnore
    @NotNull
    private List<Shelf> shelf;
}
