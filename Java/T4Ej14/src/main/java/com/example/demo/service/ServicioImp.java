package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.Repositorio;
import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicioImp implements Servicio {

	@Autowired
	private Repositorio repo;

	@Override
	@Transactional
	public void actualizarCorreoEstudiantePorId(Integer id, String nuevoEmail) {
		Estudiante estudiante = repo.getEstudiantePorId(id);
		estudiante.setEmail(nuevoEmail);
		repo.actualizarEstudiante(estudiante);
	}

	@Override
	public List<Estudiante> getEstudiantesPorCadena(String cadena) {
		List<Estudiante> estudiantes = repo.getAllEstudiantes();
		List<Estudiante> estudiantesCadena = new ArrayList<>();

		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getNombre().contains(cadena)) {
				estudiantesCadena.add(estudiante);
			}
		}
		return estudiantesCadena;

	}

	/*
	 * Crea una lista con los estudiantes del curso, añade el estudiante //
	 * introducido, le asigna la lista modificada al curso y lo actualiza en bbdd
	 */
	@Override
	@Transactional
	public void setEstudianteACurso(Estudiante estudiante, Curso curso) {
		List<Estudiante> estudiantes = curso.getEstudiantes();

		estudiantes.add(estudiante);
		curso.setEstudiantes(estudiantes);
		repo.actualizarCurso(curso);
	}

	@Override
	public List<Curso> getCursosPorNombre(String palabra) {
		List<Curso> cursos = repo.getAllCursos();
		List<Curso> cursosConPalabra = new ArrayList<>();
		for (Curso curso : cursos) {
			if (curso.getNombre().contains(palabra)) {
				cursosConPalabra.add(curso);
			}
		}
		return cursosConPalabra;
	}

	/*
	 * Guardo la lista de estudiantes del curso introducido, la recorro y comparo
	 * cada estudiante con el estudiante introducido, si coinciden, lo elimino de 
	 * la lista, actualizo la lista al curso y actualizo el curso en bbdd
	 * 
	 */
	@Override
	@Transactional
	public void BorrarEstudianteDeCurso(Estudiante estudiante, Curso curso) {
		List<Estudiante> estudiantesCurso = curso.getEstudiantes();

		for (Estudiante estudiante2 : estudiantesCurso) {
			if (estudiante2.getId() == estudiante.getId()) {
				estudiantesCurso.remove(estudiante2);// elimina el estudiante de la lista del curso
				curso.setEstudiantes(estudiantesCurso);
				repo.actualizarCurso(curso);
				break;
			}

		}
		curso.setEstudiantes(estudiantesCurso);

	}

}
