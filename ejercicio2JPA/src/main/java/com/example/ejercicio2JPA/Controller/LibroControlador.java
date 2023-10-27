package com.example.ejercicio2JPA.Controller;

import com.example.ejercicio2JPA.Entity.Libro;
import com.example.ejercicio2JPA.Repository.LibroRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroControlador
{
    private final LibroRepositorio libroRepositorio;

    public LibroControlador(LibroRepositorio libroRepositorio) {
        this.libroRepositorio = libroRepositorio;
    }

    @GetMapping
    public List<Libro> obtenerTodosLosLibros() {
        return libroRepositorio.findAll();
    }

    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroRepositorio.save(libro);
    }

    @GetMapping("/{id}")
    public Libro obtenerLibroPorId(@PathVariable Long id) {
        return libroRepositorio.findById(id)
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro nuevoLibro) {
        return libroRepositorio.findById(id)
                .map(libro -> {
                    libro.setTitulo(nuevoLibro.getTitulo());
                    libro.setAutor(nuevoLibro.getAutor());
                    libro.setAñoPublicacion(nuevoLibro.getAñoPublicacion());
                    return libroRepositorio.save(libro);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroRepositorio.deleteById(id);
    }
}
