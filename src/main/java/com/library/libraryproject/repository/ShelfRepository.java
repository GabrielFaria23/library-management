package com.library.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepository extends JpaRepository<ShelfRepository, Long> {
}
