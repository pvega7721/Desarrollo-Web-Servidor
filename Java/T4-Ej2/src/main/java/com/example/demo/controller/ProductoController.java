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

import com.example.demo.modelo.Producto;
import com.example.demo.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService servicio;

	@GetMapping
	public ResponseEntity<List<Producto>> getProductos() {
		List<Producto> productos = servicio.getProductos();
		if (productos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(productos);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Producto> getProducto(@PathVariable int id) {
		Producto producto = servicio.getProducto(id);
		if (producto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(producto);
	}

	@PostMapping
	public ResponseEntity<Void> insertarProducto(@RequestBody Producto p) {
		servicio.insertarProducto(p);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarProducto(@PathVariable int id) {
		if (servicio.borrarProducto(id)) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Producto> acutalizarProducto(@PathVariable int id, @RequestBody Producto p) {
		p.setId(id);
		Producto productoCambiado = servicio.actualizarProducto(p);
		if (productoCambiado != null) {
			return ResponseEntity.ok(productoCambiado);
		}
		return ResponseEntity.notFound().build();

	}

	@PatchMapping("/{id}")
	public ResponseEntity<Producto> actualizarProductoParcial(@PathVariable int id, @RequestBody Producto p) {
		Producto productoActual = servicio.getProducto(id);
		// Comprueba que el producto exista
		if (productoActual == null) {
			return ResponseEntity.notFound().build();
		}
		// Actualiza los campos proporcionados
		if (p.getNombre() != null) {
			productoActual.setNombre(p.getNombre());
		}
		if (p.getPrecio() != null) {
			productoActual.setPrecio(p.getPrecio());
		}
		return ResponseEntity.ok(servicio.actualizarProducto(productoActual));
	}

}
