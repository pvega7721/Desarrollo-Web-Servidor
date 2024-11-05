package ejercicios;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Multiplicar todos los elementos de un array de 10 numeros
		Integer[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9,
				10 }; /*
						 * No se puede usar stream directamente de un array, habría que pasarlo a list o
						 * usar Arrays.stream(array) Integer mult = numeros.stream().reduce(1, (a,b) ->
						 * a*b);
						 */
		Stream<Integer> streamNum = Arrays.stream(numeros);
		Integer mult = streamNum.reduce(1, (a,b) -> a*b);
		
		/*
		 * Simplificado por chatgpt: Integer mult = Arrays.stream(numeros) .reduce(1,
		 * (a, b) -> a * b);
		 */
		System.out.println(mult);
	}

}
