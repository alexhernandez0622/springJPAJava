package com.example.ejercicio1JPA.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Tarea
{
    @Id
    @GeneratedValue
    private Long id;
    private String descripcion;
    private boolean completada;

    public Tarea() {
    }

    public Tarea(String descripcion, boolean completada) {
        this.descripcion = descripcion;
        this.completada = completada;
    }
}
