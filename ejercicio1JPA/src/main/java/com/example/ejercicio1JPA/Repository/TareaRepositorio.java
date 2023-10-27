package com.example.ejercicio1JPA.Repository;

import com.example.ejercicio1JPA.Entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepositorio extends JpaRepository<Tarea, Long> {
}
