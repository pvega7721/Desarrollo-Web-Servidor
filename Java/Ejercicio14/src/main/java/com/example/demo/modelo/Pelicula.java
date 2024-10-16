package com.example.demo.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private Integer id;
	private String titulo;
	private String director;
	private LocalDate fechaLanzamiento;
	private Integer duracion;
	private List<Actor> actores;

	public Pelicula() {
		this.actores = new ArrayList<>();
	}

	public Pelicula(Integer id, String titulo, String director, LocalDate fechaLanzamiento, Integer duracion,
			List<Actor> actores) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.fechaLanzamiento = fechaLanzamiento;
		this.duracion = duracion;
		this.actores = actores;
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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}

}
