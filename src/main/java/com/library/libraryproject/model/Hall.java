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
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String hallName;

    @OneToMany(mappedBy = "hall")
    private List<Book> books;

    @OneToMany(mappedBy = "hall")
    @NotNull
    private List<Shelf> shelf;
}
