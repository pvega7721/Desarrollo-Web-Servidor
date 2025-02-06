package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.Cliente;
import com.example.demo.service.Servicio;

@Controller
@RequestMapping("/clientes")
public class HomeController {

	@Autowired
	private Servicio service;

	private List<Cliente> clientes = new ArrayList<>();

	@GetMapping("/")
	public String listarClientes(Model model) {
		model.addAttribute("clientes", service.getClientes());
		return "index";
	}
	
	
	@GetMapping("detalles")
	public String listarClientes(@RequestParam int id, Model model) {
		Cliente cliente = null;
		for(Cliente c: clientes) {
			if(c.getId() == id) {
				cliente = c;
				break;
			}
		}
		model.addAttribute("cliente",cliente);
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
		service.insertarCliente(cliente);
		
		return "redirect:/clientes";
	}
	
	@GetMapping("/ciudad")
	public String buscarPorCiudad(@ModelAttribute String ciudad, Model model) {
		List<Cliente>filtrados = new ArrayList<>();
		if(ciudad != null) {
			for (Cliente cliente : clientes) {
				if(cliente.getDireccion().getCiudad().equalsIgnoreCase(ciudad)) {
					filtrados.add(cliente);
				}
			}
		}
		model.addAttribute("clientes", filtrados);
		return "ciudad";
	}
	
	
	
	
}
