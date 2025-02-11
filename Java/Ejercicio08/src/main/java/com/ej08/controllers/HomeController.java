package com.ej08.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ej08.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class HomeController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/listarUsuarios")
	public String listarUsuarios(Model model) {
		model.addAttribute("usuarios", service.getAllUsuarios());
		return "usuarios";
	}
}
