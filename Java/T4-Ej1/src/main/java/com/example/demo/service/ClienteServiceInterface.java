package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Cliente;

public interface ClienteServiceInterface {

	List<Cliente> getClientes();

	Cliente getCliente(Integer id);

	List<Cliente> getClienteNombre(String nombre);

	Cliente insertarCliente(Cliente c);

	Boolean borrarCliente(int id);

	Cliente acualizarCliente(Cliente c);
}
