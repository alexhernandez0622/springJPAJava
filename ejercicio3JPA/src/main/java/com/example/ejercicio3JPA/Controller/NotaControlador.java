package com.example.ejercicio3JPA.Controller;

import com.example.ejercicio3JPA.Entity.Nota;
import com.example.ejercicio3JPA.Repository.NotaRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaControlador
{
    private final NotaRepositorio notaRepositorio;

    public NotaControlador(NotaRepositorio notaRepositorio) {
        this.notaRepositorio = notaRepositorio;
    }

    @GetMapping
    public List<Nota> obtenerTodasLasNotas() {
        return notaRepositorio.findAll();
    }

    @PostMapping
    public Nota crearNota(@RequestBody Nota nota) {
        return notaRepositorio.save(nota);
    }

    @GetMapping("/{id}")
    public Nota obtenerNotaPorId(@PathVariable Long id) {
        return notaRepositorio.findById(id)
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Nota actualizarNota(@PathVariable Long id, @RequestBody Nota nuevaNota) {
        return notaRepositorio.findById(id)
                .map(nota -> {
                    nota.setTitulo(nuevaNota.getTitulo());
                    nota.setContenido(nuevaNota.getContenido());
                    return notaRepositorio.save(nota);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarNota(@PathVariable Long id) {
        notaRepositorio.deleteById(id);
    }
}
