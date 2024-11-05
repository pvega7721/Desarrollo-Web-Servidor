package ejercicio11;

import java.util.Arrays;
import java.util.List;

public class Ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Curso c1 = new Curso("DAW2", 6, 10, 25);
		Curso c2 = new Curso("DAM2", 6, 10, 25);
		Curso c3 = new Curso("ASIR1", 1, 10, 25);
		Curso c4 = new Curso("CIBER", 4, 55, 25);
		Curso c5 = new Curso("DAW1", 1, 60, 25);

		List<Curso> cursos = Arrays.asList(c1, c2, c3, c4, c5);

		Long cursosMayor5 = cursos.stream().filter(n -> n.getDuracion() > 5).count();
		System.out.println("Cursos con duración mayor a 5: " + cursosMayor5);

		System.out.println("------------------------------------------------------------");

		Long cursosMenor2 = cursos.stream().filter(n -> n.getDuracion() < 2).count();
		System.out.println("Cursos con duración menor a 2: " + cursosMenor2);

		System.out.println("------------------------------------------------------------");
		System.out.println("Nombre de los cursos con más de 50 videos:");
		/*
		 * El filtro escoge los cursos con un número de videos mayor a 50. El map filtra
		 * sólo por nombre
		 */
		cursos.stream().filter(n -> n.getNumVideos() > 50).map(n -> n.getNombre()).forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		//Faltan apartados
	}

}