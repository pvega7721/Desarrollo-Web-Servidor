package com.example.demo.modelo;

import java.util.List;

public class Album {
	private Integer id;
	private String titulo;
	private Artista artistaPrincipal;
	private Integer anyoLanzamiento;
	private List<Cancion> canciones;

	public Album(Integer id, String titulo, Artista artistaPrincipal, List<Cancion> canciones,
			Integer anyoLanzamiento) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.artistaPrincipal = artistaPrincipal;
		this.canciones = canciones;
		this.anyoLanzamiento = anyoLanzamiento;
	}

	public Integer getAnyoLanzamiento() {
		return anyoLanzamiento;
	}

	public void setAnyoLanzamiento(Integer anyoLanzamiento) {
		this.anyoLanzamiento = anyoLanzamiento;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
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

	public Artista getArtistaPrincipal() {
		return artistaPrincipal;
	}

	public void setArtistaPrincipal(Artista artistaPrincipal) {
		this.artistaPrincipal = artistaPrincipal;
	}

}
