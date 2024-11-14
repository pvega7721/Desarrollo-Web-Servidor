package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository // Indica que la clase es un repositorio JPA
public class ClienteRepository {

	@PersistenceContext // o Autowired, permite utilziar EntityManager
	private EntityManager entityManager; // Conecta la bbdd con Java, permite realizar operaciones en la bbdd

	public List<Cliente> getClientes() {
		// crea la query para obtener los clientes
		Query query = (Query) entityManager.createQuery("select c from Cliente c", Cliente.class);
		// guarda en una lista de clientes lo que devuelva la query
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

	public List<Cliente> getClienteNombre(String nombre) {
		Query query = (Query) entityManager.createQuery("select c from Cliente c where c.nombre like : NOMBRE",
				Cliente.class);
		query.setParameter("NOMBRE", "%" + nombre + "%");
		List<Cliente> nombresClientes = query.getResultList();
		return nombresClientes;
	}
	
	

}
