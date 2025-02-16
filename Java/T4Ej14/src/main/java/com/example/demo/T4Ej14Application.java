package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Repository.Repositorio;
import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;
import com.example.demo.service.Servicio;
import com.example.demo.service.ServicioImp;

@SpringBootApplication
public class T4Ej14Application implements CommandLineRunner {// Importante esto

	public static void main(String[] args) {
		SpringApplication.run(T4Ej14Application.class, args);
	}

	@Autowired
	Servicio servicio;
	@Autowired
	Repositorio repo;

	@Override
	public void run(String... args) throws Exception { // El programa va aquí dentro
		// TODO Auto-generated method stub

		List<Curso> cursos1 = new ArrayList<>();
		List<Curso> cursos2 = new ArrayList<>();
		List<Estudiante> estudiantes1 = new ArrayList<>();
		List<Estudiante> estudiantes2 = new ArrayList<>();

		Estudiante e1 = new Estudiante("Pablo", "Email1", cursos1);
		Estudiante e2 = new Estudiante("Juan", "Email2", cursos2);
		Curso c1 = new Curso(estudiantes1, "Desarrollo de Aplicaciones Web", "DAW");
		Curso c2 = new Curso(estudiantes2, "Desarrollo de Aplicaciones Multiplataforma", "DAM");
		cursos1.add(c1);
//Curso
		// 1. crear curso
		repo.crearCurso(c1);
		repo.crearCurso(c2);

		// 2. agrega un estudiante a un curso
		c1.setEstudiantes(estudiantes1);
		c2.setEstudiantes(estudiantes2);

		// 3. consultar todos los cursos
		System.out.println(repo.getAllCursos());

		// 4. consultar curso por id
		repo.getCursoPorId(1);

		// 5. Buscar cursos cuyo nombre contenga una palabra
		servicio.getCursosPorNombre("Desarrollo");

		// 6. Eliminar un estudiante de un curso
		servicio.BorrarEstudianteDeCurso(e1, c1);

		// 7. Elimina un curso dado su id
		repo.BorrarCursoPorId(1);
//Estudiante
		// 1. Consultar todos los estudiantes
		repo.getAllEstudiantes();

		// 2. Consultar un estudiante dado su id
		repo.getEstudiantePorId(1);

		// 3. Actualizar el email de un estudiante dado su id
		// servicio.actualizarCorreoEstudiantePorId(1, "Correo3"); si el estudiante no
		// existe da error

		// 4. Buscar estudiantes cuyo nombre contega una cadena específica
		servicio.getEstudiantesPorCadena("P");
	}

}
