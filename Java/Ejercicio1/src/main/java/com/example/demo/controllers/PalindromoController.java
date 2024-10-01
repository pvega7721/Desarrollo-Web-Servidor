package com.example.demo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromoController {
	
	/**
	 * Método para verificar que una palabra sea palíndroma o no
	 * @param palabra
	 * @return devuelve un comentario indicando si es malíndroma o no
	 */
	@GetMapping("/validar-palindromo/{palabra}")
	public String validarPalindromo(@PathVariable String palabra) {
		int a = 0;
		int b = palabra.length()-1;
		for (int i = 0; i < palabra.length(); i++) {
			if(palabra.charAt(a)==palabra.charAt(b)) {
				a++;
				b--;
			}else {
				return "La palabra no es palíndroma";
			}
		}
		return  "La palabra " + palabra + " Es palíndroma";
	}
}
