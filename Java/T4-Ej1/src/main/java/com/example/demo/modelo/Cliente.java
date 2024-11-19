package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indica que la clase es una entidad de la BDD que vamos a mapear
@Table(name = "clientes") /*
							 * Especifica con qué tabla vamos a mapearlo. Si se llama igual que la tabla no
							 * hace falta indicarselo con name.
							 */
public class Cliente {
	/*
	 * Column es para indicar que serán las columnas de la tabla. Si el atributo se
	 * llama igual que el campo de la bdd.
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) /*
														 * Indica que el id se generará automáticamente. IDENTITY //
														 * utiliza una columna de la bdd (pk) para generar los valores
														 * únicos
														 */
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;

	public Cliente() {
		super();
	}

	public Cliente(int id, String nombre, String apellidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}
