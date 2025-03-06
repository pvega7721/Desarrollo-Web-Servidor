package com.example.demo.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;

@Repository
public interface Repositorio {
	// esudiante
	public List<Estudiante> getAllEstudiantes();
	
	public Estudiante getEstudiantePorId(Integer id);

	// curso
	public void crearCurso(Curso curso);
	
	public void actualizarCurso(Curso curso);

	public List<Curso> getAllCursos();

	public Curso getCursoPorId(Integer id);

	public void BorrarCursoPorId(Integer id);

	public void actualizarEstudiante(Estudiante estudiante);
}
