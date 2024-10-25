package com.example.demo.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
		Tarea tarea2 = new Tarea(2, "Bajar al perro", "Descripción de bajar al perro",
				LocalDate.of(2024, Month.OCTOBER, 21), "COMPLETA");
		Tarea tarea3 = new Tarea(3, "Fregar los platos", "Descripción de limpiar los platos",
				LocalDate.of(2024, Month.OCTOBER, 21), "PENDIENTE");
		Tarea tarea4 = new Tarea(4, "Limpiar la ventana", "Descripción de limpiar la ventana",
				LocalDate.of(2024, Month.OCTOBER, 20), "EN_PROCESO");

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
				tarea = mod;
			}
		}
		return ResponseEntity.noContent().build();
	}

	@PatchMapping
	public ResponseEntity<Tarea> modificarTareaParcial(@RequestBody Tarea mod) {
		for (Tarea tarea : tareas) {
			if (tarea.getId() == mod.getId()) {
				if (tarea.getDescripcion() != null) {
					tarea.setDescripcion(mod.getDescripcion());
				}
				if (tarea.getEstado() != null) {
					tarea.setEstado(mod.getEstado());
				}
				if (tarea.getFechaVencimiento() != null) {
					tarea.setFechaVencimiento(mod.getFechaVencimiento());
				}
				if (tarea.getTitulo() != null) {
					tarea.setTitulo(mod.getTitulo());
				}
			}
		}
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<Void> eliminarTarea(@PathVariable Integer id) {
		for (Tarea tarea : tareas) {
			if (tarea.getId() == id) {
				tareas.remove(tarea);
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/estado/{estado}")
	public ResponseEntity<List<Tarea>> obtenerTareaPorEstado(@PathVariable String estado) {
		List<Tarea> tareasMismoEstado = new ArrayList<>();
		for (Tarea tarea : tareas) {
			if (tarea.getEstado().equalsIgnoreCase(estado)) {
				tareasMismoEstado.add(tarea);
			}
		}
		if (tareasMismoEstado.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(tareasMismoEstado);
		}
	}

	@GetMapping("/proximas/{dias}")
	public ResponseEntity<List<Tarea>> ObtenerProximasAVencer(@PathVariable Integer dias) {
		LocalDate hoy = LocalDate.now();
		List<Tarea> tareasProximasAVencer = new ArrayList<>();
		for (Tarea tarea : tareas) {
			Period p = hoy.until(tarea.getFechaVencimiento());
			Integer diasDiferencia = p.getDays();
			if (diasDiferencia <= dias) {
				tareasProximasAVencer.add(tarea);
			}
		}
		if (tareasProximasAVencer.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(tareasProximasAVencer);
		}
	}

	@GetMapping("/contarEstado")
	public ResponseEntity<Map<String, Integer>> contarPorEstado() {
		Map<String, Integer> tareasPorEstado = new HashMap<>();
		for (Tarea tarea : tareas) {
			// Si el mapa ya contiene una clave con ese estado, sumo 1 al valor.
			if (tareasPorEstado.containsKey(tarea.getEstado())) {
				tareasPorEstado.put(tarea.getEstado(), tareasPorEstado.get(tarea.getEstado()) + 1);
			} else {
				// Si el valor no existe en el mapa, lo añadimos con valor 1 (porque es el
				// primero)
				tareasPorEstado.put(tarea.getEstado(), 1);
			}
		}
		return ResponseEntity.ok(tareasPorEstado);
	}

	@GetMapping("/buscar/{palabraClave}")
	public ResponseEntity<List<Tarea>> tareasPorPalabraClave(@PathVariable String palabraClave) {
		List<Tarea> tareasConPalabraClave = new ArrayList<>();
		for (Tarea tarea : tareas) {
			if (tarea.getDescripcion().contains(palabraClave)) {
				tareasConPalabraClave.add(tarea);
			}
		}
		if (tareasConPalabraClave.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(tareasConPalabraClave);
		}
	}

	@PatchMapping("/marcarCompletadas")
	public ResponseEntity<Void> marcarCompletadasVencidas() {
		LocalDate hoy = LocalDate.now();
		for (Tarea tarea : tareas) {
			if (tarea.getFechaVencimiento().isBefore(hoy)) {
				tarea.setEstado("COMPLETA");
			}
		}
		return ResponseEntity.noContent().build();
	}
}
