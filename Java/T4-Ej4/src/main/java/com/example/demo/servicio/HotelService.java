package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Hotel;
import com.example.demo.repository.HotelRepository;

import jakarta.transaction.Transactional;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotel;
	
	@Transactional
	public List<Hotel> getHoteles(){
		return hotel.getHoteles();
	}
	@Transactional
	public Hotel insertarHotel(Hotel h) {
		return hotel.insertarHotel(h);
	}
}
