package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
//@Table(name = "usuario") No hace falta ponerlo ya que se creará sola
public class Usuario {

	/*
	 * No hace falta usar @Column en cada atributo, ya que la tabla se crea sola
	 * gracias a lo que he mos puesto en application.properties
	 */
	@OneToOne(cascade = CascadeType.ALL) // Para que al modificar usuario, se refleje también en perfil
	@JoinColumn(name = "perfil_id")
	private Perfil perfil;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String email;

	public Usuario(Perfil perfil, Integer id, String nombre, String email) {
		super();
		this.perfil = perfil;
		this.nombre = nombre;
		this.email = email;
	}

	public Usuario() {
		super();
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [perfil=" + perfil + ", id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}

}
