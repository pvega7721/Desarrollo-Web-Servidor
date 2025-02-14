package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Cliente;
import com.example.demo.model.Direccion;
import com.example.demo.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class HomeController {

	@Autowired
	private ClienteService service;

	private List<Cliente> clientes = new ArrayList<>();

	@GetMapping("/listar")
	public String listarClientes(Model model) {
		model.addAttribute("clientes", service.getAllClientes());
		return "index";
	}

	@GetMapping("/detalles/{id}")
	public String listarClientes(@PathVariable int id, Model model) { //hay que usar @PathVariable en lugar de @RequestParam, ya que el id se pasa como parte de la url y no como parámetro de consulta
		List<Cliente> clientes = service.getAllClientes();
		Cliente cliente = null;
		for (Cliente c : clientes) {
			if (c.getId() == id) {
				cliente = c;
				break;
			}
		}
		model.addAttribute("cliente", cliente);
		return "cliente-detalle";
	}

	@GetMapping("/formulario")
	public String formulario(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "cliente-formulario";
	}

	@PostMapping("/guardarCliente")
	public String guardarCLiente(@ModelAttribute Cliente cliente) {
		System.out.println("Nombre: " + cliente.getNombre());
		service.saveCliente(cliente);

		return "redirect:/clientes/listar";
	}

	@GetMapping("/ciudad")
	public String ciudad(Model model) {
		model.addAttribute("direccion", new Direccion());
		return "ciudad";
	}

	@GetMapping("/buscarCiudad")
	public String buscarPorCiudad(@RequestParam String ciudad, Model model) {
		List<Cliente> filtrados = new ArrayList<>();
		List<Cliente> clientes = service.getAllClientes();

		model.addAttribute("direccion", new Direccion());

		if (ciudad != null && !ciudad.isEmpty()) {
			for (Cliente cliente : clientes) {
				if (cliente.getDireccion().getCiudad().equalsIgnoreCase(ciudad)) {
					filtrados.add(cliente);
				}
			}
		}
		model.addAttribute("clientes", filtrados);
		return "ciudad";
	}
	
	

}
