package ejercicios;

import java.util.Arrays;
import java.util.List;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Dada una lista de 5 nombres, filtrar e imprimir aquellos que comienzan por
		 * "A", convertirlos a mayúsculas y ordenarlo alfabéticametne
		 */
		List<String> nombres = Arrays.asList("Pablo", "Juan", "Marta", "Arturo", "Alberto");
		nombres.stream().filter(n -> n.startsWith("A")).map(String::toUpperCase).sorted().forEach(System.out::println);
	}

}
