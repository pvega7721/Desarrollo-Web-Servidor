package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Direccion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositorioImpl implements Repositorio {

	@PersistenceContext
	private EntityManager puente; // Es el objeto que se usa para interactuar con la BBDD

	@Override
	public List<Cliente> getClientes() {
		return puente.createQuery("select c from Cliente c", Cliente.class).getResultList();
	}

	@Override
	public Cliente getCliente(Integer id) {
		return puente.find(Cliente.class, id);
	}

	@Override
	public void insertarCliente(Cliente c) {
		puente.persist(c);
	}

	@Override
	public void actualizarCliente(Cliente c) {
		puente.merge(c);
	}

	// Comprueba que exista el cliente con ese id antes de borrarlo
	@Override
	public boolean borrarCliente(Integer id) {
		Cliente c = getCliente(id);
		if (c != null) {
			puente.remove(c);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Direccion getDireccion(Integer id) {
		return puente.createQuery("select d from Direccion d where d.id = :id", Direccion.class).setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public void actualizarDireccion(Direccion d) {
		puente.merge(d);
	}

	@Override
	public List<Cliente> buscarA() {
		return puente.createQuery("select c from cliente c where c.nombre like :prefijo", Cliente.class)
				.setParameter("prefijo", "A" + "%").getResultList();
	}

	@Override
	public List<Cliente> buscarNombresPorLetra(String letra) {
		return puente.createQuery("select c from cliente c where c.nombre like prefix", Cliente.class)
				.setParameter("prefix", letra + "%").getResultList();
	}

	@Override
	public List<Cliente> buscarPorCiudad(String ciudad) {
		return puente.createQuery("select c from cliente c where c.direccion.ciudad = :ciudad", Cliente.class)
				.setParameter("ciudad", ciudad).getResultList();
	}
}
