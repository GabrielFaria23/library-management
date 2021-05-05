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
@Table(name = "library")
public class Library {

    @NotNull
    private String libraryName;

    @NotNull
    @OneToMany(mappedBy = "library")
    private List<Hall> halls;
}
