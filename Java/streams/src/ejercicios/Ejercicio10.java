package ejercicios;

import java.util.Arrays;
import java.util.List;

public class Ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Dada una lista de 10 números, devuelve una lista con el cuadrado sólo de los
		 * números pares. Imprimir la lista.
		 */
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		numeros.stream().filter(n -> n % 2 == 0).map(x -> x * x).forEach(System.out::println);

	}

}
