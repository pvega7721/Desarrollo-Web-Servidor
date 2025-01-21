package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClienteRepositoryImpl {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void guadarCliente(Cliente cliente) {
		if(cliente.getId() == null) {
			entityManager.persist(cliente);
			System.out.println("Ha guardado?");
		}else {
			entityManager.merge(cliente);
		}
	}
}
