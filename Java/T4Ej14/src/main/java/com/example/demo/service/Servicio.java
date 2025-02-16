package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;

public interface Servicio {
	// estudiante
	public void actualizarCorreoEstudiantePorId(Integer id, String nuevoEmail);

	public List<Estudiante> getEstudiantesPorCadena(String cadena);

	// curso
	public void setEstudianteACurso(Estudiante estudiante, Curso curso);

	public List<Curso> getCursosPorNombre(String palabra);

	public void BorrarEstudianteDeCurso(Estudiante estudiante, Curso curso);
}
