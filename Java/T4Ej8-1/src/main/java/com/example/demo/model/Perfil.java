package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//@Table(name = "perfil") No hace falta ponerlo ya que se creará sola
public class Perfil {

	/*
	 * No hace falta usar @Column en cada atributo, ya que la tabla se crea sola
	 * gracias a lo que he mos puesto en application.properties
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String bio;
	private String estado;

	public Perfil() {
		super();
	}

	public Perfil(Integer id, String bio, String estado) {
		super();
		this.id = id;
		this.bio = bio;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", bio=" + bio + ", estado=" + estado + "]";
	}

}
