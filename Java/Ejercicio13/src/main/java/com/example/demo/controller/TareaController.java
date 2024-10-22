package com.example.demo.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.modelo.Tarea;

@RestController
@RequestMapping("/tareas")
public class TareaController {
	List<Tarea> tareas = new ArrayList<>();

	public TareaController() {

		Tarea tarea1 = new Tarea(1, "Hacer la cama", "Descripción de hacer la cama",
				LocalDate.of(2024, Month.NOVEMBER, 22), "COMPLETA");
		Tarea tarea2 = new Tarea(2, "Bajar al perro", "Descripción de hacer la cama",
				LocalDate.of(2024, Month.NOVEMBER, 21), "COMPLETA");
		Tarea tarea3 = new Tarea(3, "Fregar los platos", "Descripción de hacer la cama",
				LocalDate.of(2024, Month.NOVEMBER, 21), "PENDIENTE");
		Tarea tarea4 = new Tarea(4, "Limpiar la ventana", "Descripción de hacer la cama",
				LocalDate.of(2024, Month.NOVEMBER, 20), "EN_PROCESO");

		tareas.add(tarea1);
		tareas.add(tarea2);
		tareas.add(tarea3);
		tareas.add(tarea4);
	}

	@GetMapping
	public ResponseEntity<List<Tarea>> mostrarTareas() {
		return ResponseEntity.ok(tareas);
	}

	@GetMapping("{id}")
	public ResponseEntity<Tarea> mostrarTareaPorId(@PathVariable Integer id) {
		for (Tarea tarea : tareas) {
			if (tarea.getId() == id) {
				return ResponseEntity.ok(tarea);
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Void> crearTarea(@RequestBody Tarea tarea) {
		tareas.add(tarea);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<Tarea> modificarTareaTotal(@RequestBody Tarea mod) {
		for (Tarea tarea : tareas) {
			if (tarea.getId() == mod.getId()) {
				tarea.setDescripcion(mod.getDescripcion());
				tarea.setEstado(mod.getEstado());
				tarea.setFechaVencimiento(mod.getFechaVencimiento());
				tarea.setTitulo(mod.getTitulo());
			}
		}
		return ResponseEntity.noContent().build();
	}

	@PatchMapping
	public ResponseEntity<Tarea> modificarTareaParcial()
}
