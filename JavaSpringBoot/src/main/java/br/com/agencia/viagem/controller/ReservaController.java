package br.com.agencia.viagem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agencia.viagem.ResourceNotFoundException;
import br.com.agencia.viagem.entities.Reserva;
import br.com.agencia.viagem.repositorys.ReservaRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ViagemApplication")

public class ReservaController {

	
	@Autowired
	private ReservaRepository reservaRepository;
	
	
	//READ ou GET all
	
	@GetMapping("/reservas")
	public List<Reserva> getAllPacote(){
		return reservaRepository.findAll();
	}
	
	//READ ou GET by id
	
	@GetMapping("/reservas/{id}")
	public ResponseEntity<Reserva> getReservaById(@PathVariable Long id){
		Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reserva inexistente"));
		return ResponseEntity.ok(reserva);
	}
	
	//POST ou CREATE
	@PostMapping("/reservas")
	public Reserva createReserva(@RequestBody Reserva reserva) {
		return reservaRepository.save(reserva);
	}
	
	
	
	//PUT ou UPDATE
	@PutMapping("/reservas/{id}")
	public ResponseEntity<Reserva> updateReserva(@PathVariable Long id, @RequestBody Reserva reservaDetails){
		
		Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reserva Inexistente"));
		
		reserva.setIdReserva(reservaDetails.getIdReserva());
		reserva.setIdPacote(reservaDetails.getIdPacote());
		reserva.setIdPassageiro(reservaDetails.getIdPassageiro());
		reserva.setNome(reservaDetails.getNome());
		reserva.setTelefone1(reservaDetails.getTelefone1());
		reserva.setDestino(reservaDetails.getDestino());
		reserva.setOrigem(reservaDetails.getOrigem());
		
		Reserva newReserva = reservaRepository.save(reserva);
		
		return ResponseEntity.ok(newReserva);
	}
	
	//DELETE
	@DeleteMapping("/reservas/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteReserva(@PathVariable Long id){
		
		Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pacote Inexistente"));
		
		reservaRepository.delete(reserva);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

