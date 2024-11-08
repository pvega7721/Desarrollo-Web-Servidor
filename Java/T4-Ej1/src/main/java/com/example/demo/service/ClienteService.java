package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository cliente;
	
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
	
}
