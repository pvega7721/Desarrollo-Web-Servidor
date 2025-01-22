package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Direccion;

public interface Servicio { // Debe llevar interface

	public List<Cliente> getClientes();

	public Cliente getCliente(Integer id);

	public void insertarCliente(Cliente c);

	public Cliente actualizarCliente(Cliente c);

	public boolean eliminarCliente(Integer id);

	public Cliente actualizarDireccion(Integer id, Direccion d);

	public void actualizarSevilla();

	public void actualizarCiudadNombre(String ciudad, String nombre);

	public List<Cliente> getClientesPorCiudad(String ciudad);
}
