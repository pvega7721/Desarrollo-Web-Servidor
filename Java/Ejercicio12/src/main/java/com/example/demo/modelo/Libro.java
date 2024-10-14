package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	private Integer id;
	private String titulo;
	private String autor;
	private String editorial;
	private String isbn;
	private Integer anoPublicacion;
	private List<String> genero;
	
	public Libro() {
		this.genero = new ArrayList<>();
	}

	public Libro(Integer id, String titulo, String autor, String editorial, String isbn, Integer anoPublicacion,
			List<String> genero) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
		this.anoPublicacion = anoPublicacion;
		this.genero = genero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getAnoPublicacion() {
		return anoPublicacion;
	}

	public void setAnoPublicacion(Integer anoPublicacion) {
		this.anoPublicacion = anoPublicacion;
	}

	public List<String> getGenero() {
		return genero;
	}

	public void setGenero(List<String> genero) {
		this.genero = genero;
	}

	

}
