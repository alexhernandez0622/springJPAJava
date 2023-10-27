package com.example.ejercicio2JPA.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Libro
{
    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String autor;
    private int añoPublicacion;

    public Libro() {
    }

    public Libro(String titulo, String autor, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
    }
}
