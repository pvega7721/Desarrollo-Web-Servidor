package com.examenB.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre_cliente")
	private String nombreCliente;
	@Column(name = "tipo_habitacion")
	private String tipoHabitacion;
	@Column(name = "numero_noches")
	private Integer numeroNoches;
	@Column(name = "precio_habitacion")
	private Double precioHabitacion;
	@Column(name = "activa")
	private Boolean activa = true;
	@Column(name = "precio_total")
	private Double precioTotal;
	@Column(name = "codigo_venta")
	private Integer codigoVenta;

	public Reserva() {
		super();
	}

	public Reserva(Long id, String nombreCliente, String tipoHabitacion, Integer numeroNoches, Double precioHabitacion,
			Boolean activa, Double precioTotal, Integer codigoVenta) {
		super();
		this.id = id;
		this.nombreCliente = nombreCliente;
		this.tipoHabitacion = tipoHabitacion;
		this.numeroNoches = numeroNoches;
		this.precioHabitacion = precioHabitacion;
		this.activa = activa;
		this.precioTotal = precioTotal;
		this.codigoVenta = codigoVenta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public Integer getNumeroNoches() {
		return numeroNoches;
	}

	public void setNumeroNoches(Integer numeroNoches) {
		this.numeroNoches = numeroNoches;
	}

	public Double getPrecioHabitacion() {
		return precioHabitacion;
	}

	public void setPrecioHabitacion(Double precioHabitacion) {
		this.precioHabitacion = precioHabitacion;
	}

	public Boolean getActiva() {
		return activa;
	}

	public void setActiva(Boolean activa) {
		this.activa = activa;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Integer getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(Integer codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

}
