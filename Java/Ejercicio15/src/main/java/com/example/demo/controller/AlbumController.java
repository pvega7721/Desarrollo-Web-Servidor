package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.modelo.Album;
import com.example.demo.modelo.Artista;
import com.example.demo.modelo.Cancion;

public class AlbumController {
	public AlbumController() {
		Album listaAlbumes = new ArrayList<>();

		List<Artista> artistas1 = new ArrayList<>();
		artistas1.add(new Artista(1, "Freddie Mercury", "Británico"));
		artistas1.add(new Artista(2, "Brian May", "Británico"));

		List<Artista> artistas2 = new ArrayList<>();
		artistas2.add(new Artista(3, "Kurt Cobain", "Americano"));
		artistas2.add(new Artista(4, "Dave Grohl", "Americano"));

		List<Cancion> canciones1 = new ArrayList<>();
		canciones1.add(new Cancion(1, "Bohemian Rhapsody", artistas1));
		canciones1.add(new Cancion(2, "Don't Stop Me Now", artistas1));

		List<Cancion> canciones2 = new ArrayList<>();
		canciones2.add(new Cancion(3, "Smells Like Teen Spirit", artistas2));
		canciones2.add(new Cancion(4, "Come As You Are", artistas2));

		listaAlbumes.add(new Album(1, "A Night at the Opera", "Queen", 1975, canciones1));
		listaAlbumes.add(new Album(2, "Nevermind", "Nirvana", 1991, canciones2));
	}
}
