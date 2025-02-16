package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "curso")
public class Curso {

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "estudiante-curso", joinColumns = { @JoinColumn(name = "id_curso") }, inverseJoinColumns = {
			@JoinColumn(name = "id_estudiante") })
	private List<Estudiante> estudiantes;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nombre;

	@Column
	private String descripcion;

	public Curso() {
		super();
	}

	public Curso(List<Estudiante> estudiantes, String nombre, String descripcion) {
		super();
		this.estudiantes = estudiantes;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Curso [estudiantes=" + estudiantes + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

}
