package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Album;
import com.example.demo.modelo.Artista;
import com.example.demo.modelo.Cancion;

@RestController
@RequestMapping("/tienda")
public class AlbumController {

	List<Album> listaAlbumes = new ArrayList<>();

	List<Artista> artistas1 = new ArrayList<>();
	List<Artista> artistas2 = new ArrayList<>();

	List<Cancion> canciones1 = new ArrayList<>();
	List<Cancion> canciones2 = new ArrayList<>();

	public AlbumController() {

		Artista artista1 = new Artista(1, "Freddie Mercury", "Británico");
		Artista artista2 = new Artista(2, "Brian May", "Británico");
		Artista artista3 = new Artista(3, "Kurt Cobain", "Americano");
		Artista artista4 = new Artista(4, "Dave Grohl", "Americano");

		Cancion cancion1 = new Cancion(1, artistas1, "Bohemian Rhapsody");
		Cancion cancion2 = new Cancion(2, artistas1, "Don't Stop Me Now");

		Album album1 = new Album(1, "A Night at the Opera", artista1, canciones1, 1975);
		Album album2 = new Album(2, "Nevermind", artista2, canciones2, 1991);

		artistas1.add(artista1);
		artistas1.add(artista2);

		artistas2.add(artista3);
		artistas2.add(artista4);

		canciones1.add(cancion1);
		canciones1.add(cancion2);

		canciones2.add(new Cancion(3, artistas2, "Smells Like Teen Spirit"));
		canciones2.add(new Cancion(4, artistas2, "Come As You Are"));

		listaAlbumes.add(album1);
		listaAlbumes.add(album2);
	}

	@GetMapping("/MostrarAlbumes")
	public ResponseEntity<List<Album>> mostrarAlbumes() {
		return ResponseEntity.ok(listaAlbumes);
	}

	// OK
	@GetMapping("/Canciones-de-Album")
	public ResponseEntity<List<Cancion>> mostrarCancionesAlbum(@RequestBody Album album) {
		List<Cancion> canciones = new ArrayList<>();
		for (Cancion cancion : album.getCanciones()) {
			canciones.add(cancion);
		}
		if (canciones.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(canciones);
		}
	}

	// OK
	@GetMapping("/Canciones-De-Artista")
	public ResponseEntity<List<Cancion>> mostrarCancionesArtista(@RequestBody Artista artista) {
		List<Cancion> cancionesArtista = new ArrayList<>();
		for (Cancion cancion : canciones1) {
			// Para esto hay que añadir metodo equals en Artista
			if (cancion.getArtistas().contains(artista)) {
				cancionesArtista.add(cancion);
			}
		}
		for (Cancion cancion : canciones2) {
			if (cancion.getArtistas().contains(artista)) {
				cancionesArtista.add(cancion);
			}
		}
		if (cancionesArtista.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(cancionesArtista);
		}
	}

	// OK
	@GetMapping("/Artistas-De-Cancion")
	public ResponseEntity<List<Artista>> mostrarArtistasCancion(@RequestBody Cancion cancionIntroducida) {
		List<Artista> ArtistasCancion = new ArrayList<>();
		for (Artista artista : cancionIntroducida.getArtistas()) {
			ArtistasCancion.add(artista);
		}
		if (ArtistasCancion.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(ArtistasCancion);
		}
	}

	// OK
	@GetMapping("/todos-Artistas")
	public ResponseEntity<Set<Artista>> mostrarArtistasSinRepetir() {
		Set<Artista> artistas = new HashSet<>();
		for (Artista artista : artistas1) {
			artistas.add(artista);
		}
		for (Artista artista : artistas2) {
			artistas.add(artista);
		}
		if (artistas.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(artistas);
		}
	}

}
