package com.example.demo.modelo;

public class Cliente {
	private Integer id;
	private String nombre;
	private String username;
	private String passwd;

	public Cliente(Integer id, String nombre, String username, String passwd) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.username = username;
		this.passwd = passwd;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
