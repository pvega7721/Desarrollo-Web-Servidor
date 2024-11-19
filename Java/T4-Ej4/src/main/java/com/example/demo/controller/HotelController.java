package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Hotel;
import com.example.demo.servicio.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService servicio;

	@GetMapping()
	public ResponseEntity<List<Hotel>> getHoteles(){
		return ResponseEntity.ok(servicio.getHoteles()) ;
	}
	@PostMapping()
	public ResponseEntity<Hotel> insertarHotel(){
		return ResponseEntity.noContent().build();
	}
}
