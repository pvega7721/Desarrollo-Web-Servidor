package com.examenB.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examenB.modelo.Reserva;
import com.examenB.servicio.ReservaServicio;

@RestController
@RequestMapping("/reservas")
public class ReservaControlador {

	@Autowired
	private ReservaServicio servicio;

	@PostMapping
	public ResponseEntity<Reserva> insertarReserva(@RequestBody Reserva reserva) {
		Double precioHabitacion = reserva.getPrecioHabitacion();
		Integer nNoches = reserva.getNumeroNoches();
		Double precioTotal = precioHabitacion * nNoches;
		if (reserva.getTipoHabitacion().equals("Familiar")) {
			precioTotal = precioTotal - (precioTotal * 0.03);
		}
		reserva.setPrecioTotal(precioTotal);

		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Reserva>> getReservas() {
		List<Reserva> reservas = servicio.getReservas();
		return ResponseEntity.ok(reservas);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Reserva> modificarReserva(@PathVariable Long id, @RequestBody Reserva r) {
		r.setId(id);
		Reserva reservaCambiada = servicio.actualiarReserva(r);
		if (reservaCambiada != null) {
			return ResponseEntity.ok(reservaCambiada);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/cancelados")
	public ResponseEntity<Void> borrarReserva() {
		List<Reserva> reservas = servicio.getReservas();

		for (Reserva reserva : reservas) {
			Long id = reserva.getId();
			boolean activa = servicio.getReserva(id).getActiva();

			if (!activa && servicio.borrarReserva(id)) {
				return ResponseEntity.noContent().build();
			}
		}
		System.out.println("No se ha podido eliminar ninguna reserva");
		return ResponseEntity.notFound().build();

	}

	@PatchMapping("/nuevoPrecio/{id}")
	public ResponseEntity<Reserva> modificarPrecioHabitacion(@PathVariable Long id, @RequestBody Reserva r) {
		// Comprueba que la reserva actual exista
		Reserva reservaActual = servicio.getReserva(id);
		if (reservaActual == null) {
			return ResponseEntity.notFound().build();
		}

		if (r.getNombreCliente() != null) {
			reservaActual.setNombreCliente(r.getNombreCliente());
		}
		if (r.getTipoHabitacion() != null) {
			reservaActual.setTipoHabitacion(r.getTipoHabitacion());
		}
		if (r.getNumeroNoches() != null) {
			reservaActual.setNumeroNoches(r.getNumeroNoches());
		}
		if (r.getActiva() != null) {
			reservaActual.setActiva(r.getActiva());
		}
		if (r.getPrecioTotal() != null) {
			Double precioHabitacion = r.getPrecioHabitacion();
			Integer nNoches = r.getNumeroNoches();
			Double precioTotal = precioHabitacion * nNoches;
			if (r.getTipoHabitacion().equals("Familiar")) {
				precioTotal = precioTotal - (precioTotal * 0.03);
			}
			r.setPrecioTotal(precioTotal);
			reservaActual.setPrecioTotal(r.getPrecioTotal());
		}
		if (r.getCodigoVenta() != null) {
			reservaActual.setCodigoVenta(r.getCodigoVenta());
		}

		return ResponseEntity.ok(servicio.actualiarReserva(reservaActual));
	}

	@GetMapping("/reservasLargas/{noches}")
	public ResponseEntity<List<Reserva>> obtenerReservasMasDeXNoches(@PathVariable Integer noches) {
		List<Reserva> reservas = servicio.getReservas();
		List<Reserva> reservasMasXNoches = new ArrayList<>();
		for (Reserva reserva : reservas) {
			if (reserva.getNumeroNoches() > noches) {
				reservasMasXNoches.add(reserva);
			}
		}
		if (reservasMasXNoches.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(reservasMasXNoches);
	}

	@GetMapping("/mapaClientes")
	public ResponseEntity<Map<String, Integer>> habitacionesPorTipo() {
		List<Reserva> reservas = servicio.getReservas();
		Map<String, Integer> habitacionesPorTipo = new HashMap<>();

		for (Reserva reserva : reservas) {
			// si el mapa ya tiene una habitación de ese tipo y está activa, suma una.
			if (habitacionesPorTipo.containsKey(reserva.getTipoHabitacion())) {
				if (reserva.getActiva()) {
					habitacionesPorTipo.put(reserva.getTipoHabitacion(),
							habitacionesPorTipo.get(reserva.getNumeroNoches()) + 1);

				}
			} else {
				if (reserva.getActiva()) {
					habitacionesPorTipo.put(reserva.getTipoHabitacion(), 1);
				}
			}

		}
		return ResponseEntity.ok(habitacionesPorTipo);

	}

	@GetMapping("/masBarata")
	public ResponseEntity<Reserva> reservaMasBarata() {
		List<Reserva> reservas = servicio.getReservas();
		Reserva reservaMasBarata = reservas.get(0);
		for (Reserva reserva : reservas) {
			if (reserva.getPrecioTotal() < reservaMasBarata.getPrecioTotal()) {
				reservaMasBarata = reserva;
			}
		}
		return ResponseEntity.ok(reservaMasBarata);
	}

	@GetMapping("/reservasPorHabitacion/{tipoHabitacion}")
	public ResponseEntity<Stream<Reserva>> reservasPorHabitacionYTipo(@PathVariable String tipoHabitacion) {
		List<Reserva> reservas = servicio.getReservas();

		return ResponseEntity.ok(reservas.stream().filter(n -> n.getTipoHabitacion().equals(tipoHabitacion))
				.filter(n -> n.getActiva() == true).limit(3));
	}
}
