package com.examenB.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.examenB.modelo.Reserva;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class ReservaRepositorio {

	@PersistenceContext
	private EntityManager entityManager;

	public Reserva insertarReserva(Reserva r) {
		entityManager.persist(r);
		return r;
	}

	public List<Reserva> getReservas() {
		Query query = (Query) entityManager.createQuery("select r from Reserva r", Reserva.class);
		List<Reserva> reservas = query.getResultList();
		return reservas;
	}

	public Reserva actualizarReserva(Reserva r) {
		return entityManager.merge(r);
	}

	public Reserva getReserva(Long id) {
		Reserva reserva = entityManager.find(Reserva.class, id);
		return reserva;
	}

	public Boolean borrarReserva(Long id) {
		Reserva reserva = getReserva(id);
		if (reserva != null) {
			entityManager.remove(reserva);
			return true;
		}
		return false;
	}

}
