package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.repository.ClienteRepositoryInterface;

import jakarta.transaction.Transactional;

@Service // Indica que esta clase es el servicio
public class ClienteService implements ClienteServiceInterface{

	//Instancia de la clase repository para llamar a sus métodos
	@Autowired
	private ClienteRepositoryInterface cliente;

	@Transactional // Indica que las operaciones deben estár completas para ejecutarse, en caso de
	// no estarlo, no se ejecutan.
	@Override
	public List<Cliente> getClientes() {
		return cliente.getClientes();
	}

	@Transactional
	@Override
	public Cliente getCliente(Integer id) {
		return cliente.getCliente(id);
	}

	@Transactional
	@Override
	public List<Cliente> getClienteNombre(String nombre) {
		return cliente.getClienteNombre(nombre);
	}

	@Transactional
	@Override
	public Cliente insertarCliente(Cliente c) {
		return cliente.insertarCliente(c);
	}
	
	@Transactional
	@Override
	public Boolean borrarCliente(int id) {
		return cliente.borrarCliente(id);
	}
	
	@Transactional
	@Override
	public Cliente acualizarCliente(Cliente c) {
		return cliente.actualizarCliente(c);
	}

}
