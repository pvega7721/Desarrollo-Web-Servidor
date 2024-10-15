package com.example.demo.controller;

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

import com.example.demo.modelo.Libro;

@RestController
@RequestMapping("/libros")
public class LibroController {
	List<Libro> libros = new ArrayList<>();

	List<String> genero1 = new ArrayList<>();
	List<String> genero2 = new ArrayList<>();
	List<String> genero3 = new ArrayList<>();
	List<String> genero4 = new ArrayList<>();

	public LibroController() {
		genero1.add("Drama");
		genero1.add("Triller");
		genero2.add("Comedia");
		genero2.add("Fantasía");
		genero3.add("Economía");
		genero3.add("Cuentos infantiles");
		genero4.add("Drama");
		genero4.add("Fantasía");

		Libro libro1 = new Libro(1, "Titulo1", "Autor1", "editorial1", "isbn1", 2015, genero1);
		Libro libro2 = new Libro(2, "Titulo2", "Autor2", "editorial2", "isbn2", 2017, genero2);
		Libro libro3 = new Libro(3, "Titulo3", "Autor3", "editorial3", "isbn3", 2019, genero3);
		Libro libro4 = new Libro(4, "Titulo4", "Autor4", "editorial4", "isbn4", 2023, genero4);

		libros.add(libro1);
		libros.add(libro2);
		libros.add(libro3);
		libros.add(libro4);
	}

	@GetMapping
	public ResponseEntity<List<Libro>> mostrarLibros() {
		return ResponseEntity.ok(libros);
	}
	// Mostrar todos los libros

	@GetMapping("/{titulo}")
	public ResponseEntity<Libro> mostrarLibroTitulo(@PathVariable String titulo) {
		for (Libro libro : libros) {
			if (libro.getTitulo().equals(titulo)) {
				return ResponseEntity.ok(libro);
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Void> anadirLibro(@RequestBody Libro libro) {
		libros.add(libro);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<Void> modLibro(@RequestBody Libro mod) {
		for (Libro libro : libros) {
			if (libro.getId() == mod.getId()) {
				libro.setAnoPublicacion(mod.getAnoPublicacion());
				libro.setAutor(mod.getAutor());
				libro.setEditorial(mod.getAutor());
				libro.setGenero(mod.getGenero());
				libro.setIsbn(mod.getIsbn());
				libro.setTitulo(mod.getTitulo());
			}
		}
		return ResponseEntity.noContent().build();
	}

}
