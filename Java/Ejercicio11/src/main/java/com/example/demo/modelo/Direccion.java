package com.example.demo.modelo;

public class Direccion {
	private String calle;
	private String postalCode;
	private String ciudad;
	
	public Direccion(String calle, String postalCode, String ciudad) {
		super();
		this.calle = calle;
		this.postalCode = postalCode;
		this.ciudad = ciudad;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
}
