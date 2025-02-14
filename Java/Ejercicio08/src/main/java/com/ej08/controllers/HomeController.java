package com.ej08.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ej08.model.Perfil;
import com.ej08.model.Usuario;
import com.ej08.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class HomeController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/listar")
	public String listarUsuarios(Model model) {
		model.addAttribute("usuarios", service.getAllUsuarios());
		return "usuarios"; //Nombre del archivo html de la carpeta templates que se abrirá
	}
	
	@GetMapping("/formulario")
	public String formulario(Model model) {
		Usuario usuario = new Usuario();
		usuario.setPerfil(new Perfil()); //hay que crear un perfil vacío para asignarle al usuario
		model.addAttribute("usuario", usuario);
		return "usuario-form";
	}
	
	@PostMapping("/nuevo")
	public String nuevoUsuario(@ModelAttribute Usuario usuario) {
		service.saveUsuario(usuario);
		
		return "redirect:/usuarios/nuevo";
	}
}
