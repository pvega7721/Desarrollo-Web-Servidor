package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("mensaje","Bienvenido a Thymeleaf");
		model.addAttribute("nombre1", "Pablo Vega");
		model.addAttribute("nombre2", "<b>Pablo Vega</b>");
		model.addAttribute("role", "admin");
		return "NewFile";//nombre de mi archivo html
	}
	
	@GetMapping("/index")//necesario para que spring pueda ver el archivo index.html
	public String index() {
		return "index";
	}
		
}
