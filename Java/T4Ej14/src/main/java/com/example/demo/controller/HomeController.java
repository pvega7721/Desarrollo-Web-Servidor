package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Repository.Repositorio;
import com.example.demo.service.Servicio;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/curso")
public class HomeController {

	// Hay que poner autowired en ambas instancias
	@Autowired
	Servicio service;
	@Autowired
	Repositorio repo;

	@GetMapping("/listarCursos")
	public String listarCursos(Model model) {
		model.addAttribute("cursos", repo.getAllCursos());
		return "cursos";// Archivo html que abrirá
	}

}
