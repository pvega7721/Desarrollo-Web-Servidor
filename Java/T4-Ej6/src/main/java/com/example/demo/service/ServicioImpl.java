package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Direccion;
import com.example.demo.repository.Repositorio;

@Service
public class ServicioImpl implements Servicio {

	@Autowired
	private Repositorio repo;

	@Override
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getCliente(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarCliente(Cliente c) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente actualizarCliente(Cliente c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente actualizarDireccion(Integer id, Direccion d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarSevilla() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarCiudadNombre(String ciudad, String nombre) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cliente> getClientesPorCiudad(String ciudad) {
		// TODO Auto-generated method stub
		return null;
	}

}
