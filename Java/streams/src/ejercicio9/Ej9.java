package ejercicio9;

import java.util.ArrayList;
import java.util.List;

public class Ej9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Persona> personas = new ArrayList<>();
		Persona p1 = new Persona("Pablo", 19);
		Persona p2 = new Persona("Juan", 20);
		Persona p3 = new Persona("Marta", 29);
		Persona p4 = new Persona("María", 33);
		Persona p5 = new Persona("Alberto", 25);
		personas.add(p1);
		personas.add(p2);
		personas.add(p3);
		personas.add(p4);
		personas.add(p5);
		
		//Devolver personas mayores de 25 años ordenadas por nombre
		personas.stream().filter(n -> n.getEdad()>25).sorted((per1,per2) -> per1.getNombre().compareTo(per2.getNombre())).forEach(System.out::println);
		//No se puede usar simplemente sorted con objetos, hay que especificarle cómo deben ser ordenados (en este caso con compareTo)
	}

}
