package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Cliente;

@Repository
public interface ClienteRepository {

	List<Cliente> findAll();

	Cliente findById(Integer id);

	void save(Cliente cliente);

	void delete(Cliente cliente);

	//Cliente actualizar(Cliente cliente);

	List<Cliente> buscarNombresA();
	
	List<Cliente> buscarNombresPorLetra(String letra);
	
	List<Cliente> findByCiudad(String ciudad);
	
	
	
}


