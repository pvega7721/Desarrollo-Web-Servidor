package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Direccion;
import com.example.demo.repository.Repositorio;

import jakarta.transaction.Transactional;

@Service
public class ServicioImpl implements Servicio {

	@Autowired
	private Repositorio repo;

	@Override
	public List<Cliente> getClientes() {
		return repo.getClientes();
	}

	@Override
	public Cliente getCliente(Integer id) {
		return repo.getCliente(id);
	}

	@Transactional
	public void insertarCliente(Cliente c) {
		repo.insertarCliente(c);
	}

	@Transactional
	public Cliente actualizarCliente(Cliente c, Direccion nueva) {
		/*
		 * Busca el cliente por id. Si existe y la nueva direccion no es null, actualiza
		 * la dirección y guarda los cambios.
		 */
		Cliente cliente = repo.getCliente(c.getId());
		if (cliente != null) {
			if (nueva != null) {
				nueva.setId(cliente.getDireccion().getId());
				cliente.setDireccion(nueva);
				repo.insertarCliente(cliente);
				return cliente;
			}
		}
		return null; // si el cliente no existe o la direccion es null, devuelve null
	}

	@Transactional
	public boolean eliminarCliente(Integer id) {
		return repo.borrarCliente(id);
	}

	@Transactional
	public Cliente actualizarDireccion(Integer id, Direccion d) {
		/*
		 * Busca el cliente por id. Si existe y la direccion no es null, actualiza la
		 * dirección y guarda los cambios.
		 */
		Cliente cliente = repo.getCliente(id);
		if (cliente != null) {
			if (d != null) {
				d.setId(cliente.getDireccion().getId());
				cliente.setDireccion(d);
				repo.actualizarCliente(cliente);
				return cliente;
			}
		}
		return null;// si el cliente no existe o la direccion es null, devuelve null
	}

	@Transactional
	public void actualizarSevilla() {
		List<Cliente> clientes = repo.buscarA();
		for (Cliente cliente : clientes) {
			if (cliente.getDireccion() != null) {
				cliente.getDireccion().setCiudad("Sevilla");
				repo.actualizarCliente(cliente);
			}
		}

	}

	@Transactional
	public void actualizarCiudadNombre(String ciudad, String letra) {
		List<Cliente> clientes = repo.buscarNombresPorLetra(letra);
		for (Cliente cliente : clientes) {
			if (cliente.getDireccion() != null) {
				cliente.getDireccion().setCiudad(ciudad);
				repo.actualizarCliente(cliente);
			}
		}
	}

	@Transactional
	public List<Cliente> getClientesPorCiudad(String ciudad) {
		return repo.buscarPorCiudad(ciudad);
	}

	@Override
	public Cliente actualizarCliente(Cliente c) {
		// TODO Auto-generated method stub
		return null;
	}

}
