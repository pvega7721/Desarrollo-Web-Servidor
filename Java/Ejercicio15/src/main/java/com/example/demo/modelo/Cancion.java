package com.example.demo.modelo;

import java.util.List;

public class Cancion {
	private List<Artista> artistas;
	private Integer id;
	private String titulo;

	public Cancion(List<Artista> artistas, Integer id, String titulo) {
		super();
		this.artistas = artistas;
		this.id = id;
		this.titulo = titulo;
	}

	public List<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
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

}
