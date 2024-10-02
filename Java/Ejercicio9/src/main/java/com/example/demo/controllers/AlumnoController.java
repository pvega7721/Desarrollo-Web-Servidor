package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Alumno;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
	List<Alumno> alumnos = new ArrayList<>();

	public AlumnoController() {
		Alumno alumno1 = new Alumno(1, "Pablo", "pablo@ejemplo.com", 19, "2DAW");
		Alumno alumno2 = new Alumno(2, "Marcos", "Marcos@ejemplo.com", 18, "1DAW");
		Alumno alumno3 = new Alumno(3, "Alberto", "Alberto@ejemplo.com", 22, "2DAW");
		Alumno alumno4 = new Alumno(4, "Hugo", "Hugo@ejemplo.com", 20, "2DAW");

		alumnos.add(alumno1);
		alumnos.add(alumno2);
		alumnos.add(alumno3);
		alumnos.add(alumno4);
	}
	@GetMapping
	public List<Alumno> mostrarAlumnos() {
		return alumnos;
	}
}
