package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class HotelRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Hotel> getHoteles() {
		Query query = (Query) entityManager.createQuery("select h from Hotel h", Hotel.class);
		List<Hotel> lista = query.getResultList();
		return lista;
	}
	
	public Hotel insertarHotel(Hotel hotel) {
		entityManager.persist(hotel);
		return hotel;
	}
}
