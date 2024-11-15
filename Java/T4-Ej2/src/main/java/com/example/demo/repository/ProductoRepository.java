package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class ProductoRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Producto> getProductos() {
		Query query = (Query) entityManager.createQuery("select p from Producto p", Producto.class);

		List<Producto> productos = query.getResultList();
		return productos;
	}

	public Producto getProducto(int id) {
		Producto producto = entityManager.find(Producto.class, id);
		return producto;
	}

	public Producto insertarProducto(Producto producto) {
		entityManager.persist(producto);
		return producto;
	}

}
