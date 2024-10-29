package ejercicios;

import java.util.Arrays;
import java.util.List;

public class Ejercicio1 {

	public static void main(String[] args) {
		// Dada una lista de 5 nombres, filtrar e imprimir aquellos que comienzan por
		// "A"
		List<String> nombres = Arrays.asList("Pablo", "Juan", "Marta", "Arturo", "Alberto");

		nombres.stream().filter(n -> n.startsWith("A")).forEach(System.out::println);
	}

}
