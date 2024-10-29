package ejercicios;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ejercicio3 {

	public static void main(String[] args) {
		// Dado un array de 5 palabras, imprimir la primera letra de cada palabra
		String[] palabras = { "Armario", "Puerta", "Platano", "Martillo", "Estatua" };

		Stream<String> streamPalabras = Arrays.stream(palabras);

		streamPalabras.map(n -> n.substring(0, 1)).forEach(System.out::println);
	}

}
