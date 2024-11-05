package ejercicios;

import java.util.Arrays;

public class Ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double[] precios = { 4.49, 12.99, 30.2, 59.99, 19.99 };

		/*
		 * No se puede asignar directamente a un double porque .filter devuelve otro //
		 * stream. Habría que imprimirlo directamente en el stream
		 */
		Arrays.stream(precios).filter(n -> n > 20.0).forEach(System.out::println);

	}

}
