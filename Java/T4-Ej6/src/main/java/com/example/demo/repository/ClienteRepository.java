package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;

@Repository
public class ClienteRepository {

	List<Cliente> findAll(){
		Query<> 
	}
	
	Cliente findBy(Integer id);
	
	void save(Cliente cliente);
	
	void delete(Cliente cliente);
}
