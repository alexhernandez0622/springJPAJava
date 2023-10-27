package com.example.ejercicio1JPA.Controller;

import com.example.ejercicio1JPA.Entity.Tarea;
import com.example.ejercicio1JPA.Repository.TareaRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// se coloca en la parte superior de la clase TareaControlador, lo que significa que todas las solicitudes que comiencen con la ruta "/tareas" serán manejadas por este controlador.
@RequestMapping("/tareas")
public class TareaControlador {
    private final TareaRepositorio tareaRepositorio;

    // Constructor que inyecta una instancia de TareaRepositorio.
    public TareaControlador(TareaRepositorio tareaRepositorio) {
        this.tareaRepositorio = tareaRepositorio;
    }

    // Método que responde a solicitudes GET a la ruta "/tareas".
    @GetMapping
    public List<Tarea> obtenerTodasLasTareas() {
        // Obtiene todas las tareas del repositorio y las devuelve como una lista.
        return tareaRepositorio.findAll();
    }

    // Método que responde a solicitudes POST a la ruta "/tareas".
    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        // Guarda una nueva tarea en el repositorio y la devuelve.
        return tareaRepositorio.save(tarea);
    }

    // Método que responde a solicitudes GET a la ruta "/tareas/{id}" donde {id} es un parámetro de la URL.
    @GetMapping("/{id}")
    public Tarea obtenerTareaPorId(@PathVariable Long id) {
        // Busca una tarea por su ID en el repositorio y la devuelve; si no se encuentra, devuelve null.
        return tareaRepositorio.findById(id).orElse(null);
    }

    // Método que responde a solicitudes PUT a la ruta "/tareas/{id}" donde {id} es un parámetro de la URL.
    @PutMapping("/{id}")
    public Tarea actualizarTarea(@PathVariable Long id, @RequestBody Tarea nuevaTarea) {
        // Busca una tarea por su ID en el repositorio y la actualiza con los datos de nuevaTarea, luego la guarda y la devuelve.
        // Si no se encuentra la tarea, devuelve null.
        return tareaRepositorio.findById(id)
                .map(tarea -> {
                    tarea.setDescripcion(nuevaTarea.getDescripcion());
                    tarea.setCompletada(nuevaTarea.isCompletada());
                    return tareaRepositorio.save(tarea);
                })
                .orElse(null);
    }

    // Método que responde a solicitudes DELETE a la ruta "/tareas/{id}" donde {id} es un parámetro de la URL.
    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id) {
        // Elimina una tarea por su ID del repositorio.
        tareaRepositorio.deleteById(id);
    }
}

