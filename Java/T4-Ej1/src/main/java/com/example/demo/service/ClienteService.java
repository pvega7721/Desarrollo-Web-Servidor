package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service // Indica que esta clase es el servicio
public class ClienteService {

	@Autowired
	private ClienteRepository cliente;

	@Transactional // Indica que las operaciones deben estár completas para ejecutarse, en caso de
	// no estarlo, no se ejecutan.
	public List<Cliente> getClientes() {
		return cliente.getClientes();
	}

	@Transactional
	public Cliente getCliente(Integer id) {
		return cliente.getCliente(id);
	}

	@Transactional
	public Cliente insertarCliente(Cliente c) {
		return cliente.insertarCliente(c);
	}

	@Transactional
	public List<Cliente> getClienteNombre(String nombre) {
		return cliente.getClienteNombre(nombre);
	}

}
