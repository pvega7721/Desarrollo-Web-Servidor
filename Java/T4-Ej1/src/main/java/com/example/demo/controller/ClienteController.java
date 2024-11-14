package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Cliente;
import com.example.demo.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService servicio;

	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes() {
		List<Cliente> listaClientes = servicio.getClientes();
		return ResponseEntity.ok(listaClientes);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity <Cliente> getClienteId(@PathVariable int id) {
		Cliente cliente = servicio.getCliente(id);
			return ResponseEntity.ok(cliente);
	}

	@PostMapping
	public ResponseEntity<Cliente> insertarCliente(@RequestBody Cliente cliente) {
		servicio.insertarCliente(cliente);
		return ResponseEntity.ok(cliente);
	}

	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<List<Cliente>> getClienteNombre(@PathVariable String nombre) {
		List<Cliente> listaNombres = servicio.getClienteNombre(nombre);
		servicio.getClienteNombre(nombre);
		return ResponseEntity.ok(listaNombres);
	}

}