package com.example.demo.controller;

import java.util.List;

import com.example.demo.modelo.Artista;

public class AlbumController {
	public AlbumController() {
        listaAlbumes = new ArrayList<>();
 
        List<Artista> artistas1 = new ArrayList<>();
        artistas1.add(new Artista(1L, "Freddie Mercury", "Británico"));
        artistas1.add(new Artista(2L, "Brian May", "Británico"));
 
        List<Artista> artistas2 = new ArrayList<>();
        artistas2.add(new Artista(3L, "Kurt Cobain", "Americano"));
        artistas2.add(new Artista(4L, "Dave Grohl", "Americano"));
 
        List<Cancion> canciones1 = new ArrayList<>();
        canciones1.add(new Cancion(1L, "Bohemian Rhapsody", artistas1));
        canciones1.add(new Cancion(2L, "Don't Stop Me Now", artistas1));
 
        List<Cancion> canciones2 = new ArrayList<>();
        canciones2.add(new Cancion(3L, "Smells Like Teen Spirit", artistas2));
        canciones2.add(new Cancion(4L, "Come As You Are", artistas2));
 
        listaAlbumes.add(new Album(1L, "A Night at the Opera", "Queen", 1975, canciones1));
        listaAlbumes.add(new Album(2L, "Nevermind", "Nirvana", 1991, canciones2));
    }
}
