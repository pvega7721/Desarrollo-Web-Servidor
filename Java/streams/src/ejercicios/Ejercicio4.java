package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio4 {

	public static void main(String[] args) {
		/*
		 * Dado un array de 5 palabras, devuelve una lista con la longitud de cada
		 * palabra. Imprime la lista.
		 */
		String[] palabras = { "Armario", "Puerta", "Platano", "Martillo", "Estatua" };

		Stream<String> streamPalabras = Arrays.stream(palabras);

		List<String> listaPalabras = streamPalabras.collect(Collectors.toList());
		
		List<Integer> longitudes = new ArrayList<>();
		
		for (String string : listaPalabras) {
			Integer longitud = string.length();
			longitudes.add(longitud);
		}

		System.out.println(longitudes);

	}

}
