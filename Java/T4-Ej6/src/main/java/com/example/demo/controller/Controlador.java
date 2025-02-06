package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.modelo.Direccion;
import com.example.demo.service.Servicio;

@RestController
@RequestMapping("/clientes")
public class Controlador {

	@Autowired
	private Servicio service;

	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes() {
		List<Cliente> lista = service.getClientes();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getCliente(@PathVariable Integer id) {
		Cliente c = service.getCliente(id);
		if (c == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(c);
		}
	}

	@PostMapping
	public ResponseEntity<Cliente> insertarCliente(@RequestBody Cliente c) {
		service.insertarCliente(c);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<Cliente> actualizar(@RequestBody Cliente c) {
		Cliente nuevo = service.actualizarCliente(c);

		if (nuevo != null) {
			return ResponseEntity.ok(nuevo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrar(@PathVariable Integer id) {
		if (service.eliminarCliente(id)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Cliente> actualizarDireccion(@PathVariable Integer id, @RequestBody Direccion d) {
		Cliente nuevo = service.actualizarDireccion(id, d);

		if (nuevo != null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PatchMapping("/Sevilla")
	public ResponseEntity<Void> actualizarSevilla() {
		service.actualizarSevilla();
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{inicial}/direccion/{ciudadNueva}")
	public ResponseEntity<Void> actualizarCiudad(@PathVariable String inicial, @PathVariable String ciudadNueva) {
		service.actualizarCiudadNombre(inicial, ciudadNueva);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/buscarCiudad/{ciudad}")
	public ResponseEntity<List<Cliente>> getClientePorCiudad(@PathVariable String ciudad) {
		List<Cliente> lista = service.getClientesPorCiudad(ciudad);
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}

}
