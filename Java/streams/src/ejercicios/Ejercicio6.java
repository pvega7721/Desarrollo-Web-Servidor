package ejercicios;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ejercicio6 {

	public static void main(String[] args) {
		/* Crea un array de 10 enteros y devuelve el numero de pares que hay */
		Integer[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		Stream<Integer> numPares = Arrays.stream(numeros).filter(n -> n % 2 ==0);
		System.out.println();
	}

}
