package com.example.ejercicio2JPA.Repository;

import com.example.ejercicio2JPA.Entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {
}