package com.example.demo.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class RepositorioImp implements Repositorio {

	@PersistenceContext
	private EntityManager puente;

	// Estudiante
	@Override
	public List<Estudiante> getAllEstudiantes() {
		Query query = puente.createQuery("select e from Estudiante e", Estudiante.class);
		List<Estudiante> estudiantes = query.getResultList();
		return estudiantes;
	}

	@Override
	public Estudiante getEstudiantePorId(Integer id) {
		Estudiante estudiante = puente.find(Estudiante.class, id);
		return estudiante;
	}

	// curso
	@Override
	@Transactional
	public void crearCurso(Curso curso) {
		puente.persist(curso);
	}
	
	@Override
	@Transactional
	public void actualizarCurso(Curso curso) {
		puente.merge(curso);
	}
	
	@Override
	public List<Curso> getAllCursos() {
		Query query = puente.createQuery("select c from Curso c", Curso.class);
		List<Curso> cursos = query.getResultList();
		return cursos;
	}

	@Override
	public Curso getCursoPorId(Integer id) {
		Curso curso = puente.find(Curso.class, id);
		return curso;
	}

	@Override
	@Transactional
	public void BorrarCursoPorId(Integer id) {
		Curso curso = getCursoPorId(id);
		puente.remove(curso);
	}
	
	@Override
	@Transactional
	public void actualizarEstudiante(Estudiante estudiante) {
		puente.merge(estudiante);
	}

}
