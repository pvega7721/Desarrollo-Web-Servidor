package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Cliente;

@RestController
public class ClienteController {
	List<Cliente> clientes = new ArrayList<>();

	public ClienteController() {
		Cliente cliente1 = new Cliente(1, "Pablo Vega", "pvega", "contraseña1");
		Cliente cliente2 = new Cliente(2, "Juan Lopez", "jlopez", "contraseña2");
		Cliente cliente3 = new Cliente(3, "Jorge Martínez", "jmartinez", "contraseña3");
		Cliente cliente4 = new Cliente(4, "María Flores", "mflores", "contraseña4");

		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);

	}

	@GetMapping("/clientes")
	public List<Cliente> obtenerClientes() {
		return clientes;
	}
	@PostMapping("/clientes")
	public Cliente postCliente(@RequestBody Cliente cliente) {
		clientes.add(cliente);
		return cliente;
	}

	@GetMapping("/clientes/{username}")
	public Cliente obtenerCliente(@PathVariable String username) {
		for (Cliente cliente : clientes) {
			if (cliente.getUsername().equals(username)) {
				return cliente;
			}
		}
		return null;
	}

}
