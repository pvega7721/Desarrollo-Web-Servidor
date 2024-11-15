package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Producto;
import com.example.demo.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoService {
	@Autowired
	private ProductoRepository producto;

	@Transactional
	public List<Producto> getProductos() {
		return producto.getProductos();
	}

	@Transactional
	public Producto getProducto(int id) {
		return producto.getProducto(id);
	}

	@Transactional
	public Producto insertarProducto(Producto p) {
		return producto.insertarProducto(p);
	}
}
