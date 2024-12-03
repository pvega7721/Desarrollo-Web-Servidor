package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Cliente;

public interface ClienteRepositoryInterface {

	List<Cliente> getClientes();

	Cliente getCliente(int id);

	List<Cliente> getClienteNombre(String nombre);

	Boolean borrarCliente(int id);

	Cliente insertarCliente(Cliente cliente);

	Cliente actualizarCliente(Cliente cliente);

}
