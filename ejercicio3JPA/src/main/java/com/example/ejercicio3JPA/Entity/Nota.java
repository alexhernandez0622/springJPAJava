package com.example.ejercicio3JPA.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Nota
{
    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String contenido;

    public Nota() {
    }

    public Nota(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }
}
