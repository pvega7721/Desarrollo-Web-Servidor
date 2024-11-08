package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class ClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Cliente> getClientes() {

		Query query = (Query) entityManager.createQuery("select c from Cliente c", Cliente.class);
		List<Cliente> lista = query.getResultList();
		return lista;
	}
	
	public Cliente getCliente(int id) {
		Cliente cliente = entityManager.find(Cliente.class, id);
		return cliente;
	}
	
	public Cliente insertarCliente(Cliente cliente) {
		entityManager.persist(cliente);
		System.out.println(cliente);
		return cliente;
	}

}
