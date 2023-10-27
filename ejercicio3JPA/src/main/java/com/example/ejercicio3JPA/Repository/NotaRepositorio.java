package com.example.ejercicio3JPA.Repository;

import com.example.ejercicio3JPA.Entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepositorio extends JpaRepository<Nota, Long> {
}