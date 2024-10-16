package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

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
		genero1.add("Novela");
		genero2.add("Comedia");
		genero2.add("Fantasía");
		genero3.add("Economía");
		genero3.add("Cuentos infantiles");
		genero4.add("Novela");
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

	// Mostrar todos los libros
	@GetMapping
	public ResponseEntity<List<Libro>> mostrarLibros() {
		return ResponseEntity.ok(libros);
	}

	// Consultar un libro por su título
	@GetMapping("/{titulo}")
	public ResponseEntity<Libro> mostrarLibroTitulo(@PathVariable String titulo) {
		for (Libro libro : libros) {
			if (libro.getTitulo().equals(titulo)) {
				return ResponseEntity.ok(libro);
			}
		}
		return ResponseEntity.notFound().build();
	}

	// Crear un libro nuevo
	@PostMapping
	public ResponseEntity<Void> anadirLibro(@RequestBody Libro libro) {
		libros.add(libro);
		return ResponseEntity.noContent().build();
	}

	// Modificar un libro de manera total
	@PutMapping
	public ResponseEntity<Void> modLibroTotal(@RequestBody Libro mod) {
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

	// Modificar un libro de manera parcial
	@PatchMapping
	public ResponseEntity<Void> modLibroParcial(@RequestBody Libro mod) {
		for (Libro libro : libros) {
			if (libro.getId() == mod.getId()) {
				if (libro.getAnoPublicacion() != null) {
					libro.setAnoPublicacion(mod.getAnoPublicacion());
				}
				if (libro.getAutor() != null) {
					libro.setAutor(mod.getAutor());
				}
				if (libro.getEditorial() != null) {
					libro.setEditorial(mod.getEditorial());
				}
				if (libro.getGenero() != null) {
					libro.setGenero(mod.getGenero());
				}
				if (libro.getIsbn() != null) {
					libro.setIsbn(mod.getIsbn());
				}
				if (libro.getTitulo() != null) {
					libro.setTitulo(mod.getTitulo());
				}
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	// Eliminar un libro por su ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarLibro(@PathVariable Integer id) {
		for (Libro libro : libros) {
			if (libro.getId() == id) {
				libros.remove(libro);
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	// Obtener libros cuyo género sea novela
	@GetMapping("/novelas")
	public ResponseEntity<List<Libro>> obtenerNovelas() {
		List<Libro> novelas = new ArrayList<>();
		for (Libro libro : libros) {
			if (libro.getGenero().contains("Novela")) {
				novelas.add(libro);
			}
		}
		if (novelas.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(novelas);
		}
	}
	
	//Obtener libros por género
	@GetMapping("/{genero}")
	public ResponseEntity<List<Libro>> obtenerLibroGenero(@PathVariable String genero){
		List<Libro> porGenero = new ArrayList<>();
		for(Libro libro: libros) {
			if(libro.getGenero().contains(genero)) {
				porGenero.add(libro);
			}
		}
		if(porGenero.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(porGenero);
		}
		
	}
	//NO FUNCIONA
	/*
	@GetMapping("/{numLibros}")
	public ResponseEntity<List<Libro>> obtenerAutoresConMasDeXLibros(@PathVariable Integer numLibros){
		
	}
	*/
	
	
}
