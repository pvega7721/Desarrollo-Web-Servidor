package com.example.demo.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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

import com.example.demo.modelo.Actor;
import com.example.demo.modelo.Pelicula;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
	List<Pelicula> peliculas = new ArrayList<>();

	List<Actor> reparto1 = new ArrayList<>();
	List<Actor> reparto2 = new ArrayList<>();
	List<Actor> reparto3 = new ArrayList<>();
	List<Actor> reparto4 = new ArrayList<>();
	List<Actor> reparto5 = new ArrayList<>();

	Actor actor1 = new Actor(1, "Leonardo DiCaprio", "Estadounidense");
	Actor actor2 = new Actor(2, "Penélope Cruz", "Española");
	Actor actor3 = new Actor(3, "Jackie Chan", "Chino");
	Actor actor4 = new Actor(4, "Salma Hayek", "Mexicana");
	Actor actor5 = new Actor(5, "Emma Thompson", "Británica");

	public PeliculaController() {

		reparto1.add(actor1);

		Pelicula pelicula1 = new Pelicula(1, "Titulo1", "director1", LocalDate.of(2021, Month.APRIL, 17), 120,
				reparto1);
		Pelicula pelicula2 = new Pelicula(2, "Titulo2", "director2", LocalDate.of(2023, Month.MARCH, 12), 142,
				reparto2);
		Pelicula pelicula3 = new Pelicula(3, "Titulo3", "director2", LocalDate.of(2021, Month.FEBRUARY, 26), 190,
				reparto3);
		Pelicula pelicula4 = new Pelicula(4, "Titulo4", "director4", LocalDate.of(2018, Month.APRIL, 02), 135,
				reparto4);
		Pelicula pelicula5 = new Pelicula(5, "Titulo5", "director1", LocalDate.of(2014, Month.JULY, 20), 100, reparto5);

		peliculas.add(pelicula1);
		peliculas.add(pelicula2);
		peliculas.add(pelicula3);
		peliculas.add(pelicula4);
		peliculas.add(pelicula5);

		reparto1.add(actor1);
		reparto1.add(actor2);
		reparto2.add(actor3);
		reparto2.add(actor4);
		reparto3.add(actor5);
		reparto3.add(actor1);
		reparto4.add(actor3);
		reparto4.add(actor2);
		reparto5.add(actor4);
		reparto5.add(actor5);
	}

	// FUNCIONA
	@GetMapping
	public ResponseEntity<List<Pelicula>> mostrarPeliculas() {
		return ResponseEntity.ok(peliculas);
	}

	// FUNCIONA
	@GetMapping("/{titulo}")
	public ResponseEntity<Pelicula> mostrarPeliculaTitulo(@PathVariable String titulo) {
		for (Pelicula pelicula : peliculas) {
			if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
				return ResponseEntity.ok(pelicula);
			}
		}
		return ResponseEntity.notFound().build();
	}

	// FUNCIONA
	@GetMapping("/director/{director}")
	public ResponseEntity<List<Pelicula>> obtenerPorDirector(@PathVariable String director) {
		List<Pelicula> peliculasMismoDirector = new ArrayList<>();
		for (Pelicula pelicula : peliculas) {
			if (pelicula.getDirector().equals(director)) {
				peliculasMismoDirector.add(pelicula);
			}
			if (peliculasMismoDirector.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
		}
		return ResponseEntity.ok(peliculasMismoDirector);
	}

	// FUNCIONA
	@GetMapping("/cincoanyos")
	public ResponseEntity<List<Pelicula>> UltimosCincoAnyos() {
		List<Pelicula> peliculasCincoAnyos = new ArrayList<>();
		LocalDate anyoActual = LocalDate.now();
		for (Pelicula pelicula : peliculas) {
			Period p = pelicula.getFechaLanzamiento().until(anyoActual);
			Integer anyosDiferencia = p.getYears();
			if (anyosDiferencia <= 5) {
				peliculasCincoAnyos.add(pelicula);
			}
		}
		if (peliculasCincoAnyos.isEmpty()) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.ok(peliculasCincoAnyos);
		}
	}

	// FUNCIONA
	@GetMapping("/mayorDuracion")
	public ResponseEntity<Pelicula> MayorDuracion() {
		Integer max = 0;
		for (Pelicula pelicula : peliculas) {
			if (pelicula.getDuracion() > max) {
				max = pelicula.getDuracion();
			}
		}
		for (Pelicula pelicula : peliculas) {
			if (pelicula.getDuracion() == max) {
				return ResponseEntity.ok(pelicula);
			}
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/nPeliculas/{nPeliculas}")
	public ResponseEntity<Map<String, Integer>> directorXPeliculas(@PathVariable Integer nPeliculas) {
		Map<String, Integer> directorYPeliculas = new HashMap<String, Integer>();
		Map<String, Integer> directorMasXPeliculas = new HashMap<String, Integer>();
		for (Pelicula pelicula : peliculas) {
			String director = pelicula.getDirector();
			if (directorYPeliculas.containsKey(director)) {

				directorYPeliculas.put(director, directorYPeliculas.get(director) + 1);
			} else {
				directorYPeliculas.put(director, 1);
			}
		}
		Set<Entry<String, Integer>> pares = directorYPeliculas.entrySet();
		for (Entry<String, Integer> par : pares) {
			if (par.getValue() > nPeliculas) {
				directorMasXPeliculas.put(par.getKey(), par.getValue());
			}
		}
		if (directorMasXPeliculas.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(directorMasXPeliculas);
		}
	}

	@GetMapping("/actoresSinRepetir")
	public ResponseEntity<Set<Actor>> obtenerActoresSinRepetir() {
		Set<Actor> actores = new HashSet<>();
		for (Pelicula pelicula : peliculas) {
			for (Actor actor : pelicula.getActores()) {
				actores.add(actor);
			}
		}
		if (actores.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {

			return ResponseEntity.ok(actores);
		}
	}

	@GetMapping("/nacionalidad/{nacionalidad}")
	public ResponseEntity<Set<Actor>> obtenerActoresPorNacionalidad(@PathVariable String nacionalidad) {
		Set<Actor> actores = new HashSet<>();
		for (Pelicula pelicula : peliculas) {
			for (Actor actor : pelicula.getActores()) {
				if (actor.getNacionalidad().equalsIgnoreCase(nacionalidad)) {
					actores.add(actor);
				}
			}
		}
		if (actores.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {

			return ResponseEntity.ok(actores);
		}
	}

	// FUNCIONA
	@PostMapping
	public ResponseEntity<Void> anadirPelicula(@RequestBody Pelicula pelicula) {
		peliculas.add(pelicula);
		return ResponseEntity.noContent().build();
	}

	// FUNCIONA
	@PatchMapping
	public ResponseEntity<Void> modificarPeliculaParcial(@RequestBody Pelicula mod) {
		for (Pelicula pelicula : peliculas) {
			if (pelicula.getId() == mod.getId()) {
				if (pelicula.getActores() != null) {
					pelicula.setActores(mod.getActores());
				}
				if (pelicula.getDirector() != null) {
					pelicula.setDirector(mod.getDirector());
				}
				if (pelicula.getDuracion() != null) {
					pelicula.setDuracion(mod.getDuracion());
				}
				if (pelicula.getFechaLanzamiento() != null) {
					pelicula.setDuracion(mod.getDuracion());
				}
				if (pelicula.getTitulo() != null) {
					pelicula.setTitulo(mod.getTitulo());
				}
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	// NO FUNCIONA
	@PutMapping
	public ResponseEntity<Pelicula> modificarPeliculaTotal(@RequestBody Pelicula mod) {
		for (Pelicula pelicula : peliculas) {
			if (pelicula.getId() == mod.getId()) {
				// peliculas.set(pelicula, mod) probar esto
				pelicula.setActores(mod.getActores());
				pelicula.setDirector(mod.getDirector());
				pelicula.setDuracion(mod.getDuracion());
				pelicula.setFechaLanzamiento(mod.getFechaLanzamiento());
				pelicula.setTitulo(mod.getTitulo());
			}
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();
	}

	// FUNCIONA
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarPelicula(@PathVariable Integer id) {
		for (Pelicula pelicula : peliculas) {
			if (pelicula.getId() == id) {
				peliculas.remove(pelicula);
				return ResponseEntity.noContent().build();
			}

		}
		return ResponseEntity.notFound().build();
	}
}