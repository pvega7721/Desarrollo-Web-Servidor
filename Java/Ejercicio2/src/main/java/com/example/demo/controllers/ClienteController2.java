package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController2 {
	List<Cliente> clientes = new ArrayList<>();

	public ClienteController2() {
		Cliente cliente1 = new Cliente(1, "Pablo Vega", "pvega", "contraseña1");
		Cliente cliente2 = new Cliente(2, "Juan Lopez", "jlopez", "contraseña2");
		Cliente cliente3 = new Cliente(3, "Jorge Martínez", "jmartinez", "contraseña3");
		Cliente cliente4 = new Cliente(4, "María Flores", "mflores", "contraseña4");

		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);

	}

	@GetMapping
	public List<Cliente> obtenerClientes() {
		return clientes;
	}

	@GetMapping("/{username}")
	public Cliente obtenerCliente(@PathVariable String username) {
		for (Cliente cliente : clientes) {
			if (cliente.getUsername().equals(username)) {
				return cliente;
			}
		}
		return null;
	}

	@PostMapping
	public Cliente postCliente(@RequestBody Cliente cliente) {
		clientes.add(cliente);
		return cliente;
	}

	@PutMapping
	public Cliente putCliente(@RequestBody Cliente modif) {
		for (Cliente cliente : clientes) {
			if (cliente.getId() == modif.getId()) {
				cliente.setNombre(modif.getNombre());
				cliente.setPasswd(modif.getPasswd());
				cliente.setUsername(modif.getUsername());
				return cliente;
			}
		}
		return null;

	}

	@DeleteMapping("/{id}")
	public Cliente deleteCliente(@PathVariable int id) {

		Iterator<Cliente> iterador = clientes.iterator();
		while (iterador.hasNext()) {
			Cliente cliente = iterador.next();
			if (cliente.getId() == id) {
				iterador.remove();
				return cliente;
			}
		}
		return null;
	}
	
	//Modifica un único atributo del objeto
		@PatchMapping
		public Cliente pathCliente(@RequestBody Cliente modif) {
			for (Cliente cliente : clientes) {
				if (cliente.getId() == modif.getId()) {
					if (modif.getNombre() != null) {
						System.out.println("nombre");
						cliente.setNombre(modif.getNombre());
					}
					if (modif.getNombre() != null) {
						System.out.println("pass");
						cliente.setNombre(modif.getPasswd());
					}
					if (modif.getNombre() != null) {
						System.out.println("user");
						cliente.setNombre(modif.getUsername());
					}

					return cliente;

				}
			}
			return null;
		}

	}