package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Direccion;

public interface Repositorio { // Debe llevar interface

	// Obtener todos los clientes
	public List<Cliente> getClientes();

	// Obtener cliente por ID
	public Cliente getCliente(Integer id);

	// Insertar cliente nuevo
	public void insertarCliente(Cliente c);

	// Actualiza los datos de un cliente
	public void actualizarCliente(Cliente c);

	// Eliminar cliente por id
	public boolean borrarCliente(Integer id);

	// Obtener dirección por id
	public Direccion getDireccion(Integer id);

	// Actualizar la dirección
	public void actualizarDireccion(Direccion d);

	//
	public List<Cliente> buscarA();

	//
	public List<Cliente> buscarNombresPorLetra(String letra);

	//
	public List<Cliente> buscarPorCiudad(String ciudad);
}
