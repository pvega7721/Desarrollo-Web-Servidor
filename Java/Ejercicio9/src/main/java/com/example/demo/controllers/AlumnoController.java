package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/{email}")
	public Alumno mostrarAluno(@PathVariable String email) {
		for (Alumno alumno : alumnos) {
			if (alumno.getEmail().equals(email)) {// Para comparar cadenas se usa .equals()
				return alumno;
			}
		}
		return null;

	}

	@PostMapping
	public Alumno postAlumno(@RequestBody Alumno alumno) {
		alumnos.add(alumno);
		return alumno;
	}

	@PatchMapping
	public Alumno modAlumno(@RequestBody Alumno mod) {
		for (Alumno alumno : alumnos) {
			if (alumno.getId() == mod.getId()) {
				if (mod.getNombre() != null) {
					alumno.setNombre(mod.getNombre());
				}
				if (mod.getCurso() != null) {
					alumno.setCurso(mod.getCurso());
				}
				if (mod.getEdad() != null) {
					alumno.setEdad(mod.getEdad());
				}
				if (mod.getEmail() != null) {
					alumno.setEmail(mod.getEmail());
				}
				return alumno;
			}
		}
		return null;
	}

	@DeleteMapping("{id}")
	public Alumno deleteAumno(@PathVariable Integer id) {
		Iterator<Alumno> iterador = alumnos.iterator();
		while (iterador.hasNext()) {
			Alumno alumno = iterador.next();
			if (alumno.getId() == id) {
				iterador.remove();
				return alumno;
			}
		}
		return null;
	}

}