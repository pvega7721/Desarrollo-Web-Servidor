package ejercicios;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ejercicio5 {

	public static void main(String[] args) {
		/*
		 * Dado un array de 5 palabras, devolver aquellas palabras que tengan más de 5
		 * caracteres
		 */
		String[] palabras = { "Armario", "Puerta", "Platano", "Martillo", "Luz" };

		Stream<String> palabrasString = Arrays.stream(palabras);

		palabrasString.filter(n -> n.length() > 5).forEach(System.out::println);
	}

}
