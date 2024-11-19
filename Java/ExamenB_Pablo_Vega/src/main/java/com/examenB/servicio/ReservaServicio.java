package com.examenB.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenB.modelo.Reserva;
import com.examenB.repositorio.ReservaRepositorio;

import jakarta.transaction.Transactional;

@Service
public class ReservaServicio {

	@Autowired
	private ReservaRepositorio reserva;

	@Transactional
	public Reserva insertarReserva(Reserva r) {
		return reserva.insertarReserva(r);
	}

	@Transactional
	public List<Reserva> getReservas() {
		return reserva.getReservas();
	}

	@Transactional
	public Reserva getReserva(Long id) {
		return reserva.getReserva(id);
	}

	@Transactional
	public Reserva actualiarReserva(Reserva r) {
		return reserva.actualizarReserva(r);
	}

	@Transactional
	public boolean borrarReserva(Long id) {
		return reserva.borrarReserva(id);
	}
}
