package com.example.demo.modelo;

public class Album {
	private Integer id;
	private String titulo;
	private Artista artistaPrincipal;

	public Album(Integer id, String titulo, Artista artistaPrincipal) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.artistaPrincipal = artistaPrincipal;
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
