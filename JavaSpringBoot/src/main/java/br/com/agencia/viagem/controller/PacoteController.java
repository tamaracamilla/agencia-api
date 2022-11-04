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
import br.com.agencia.viagem.entities.Pacote;
import br.com.agencia.viagem.repositorys.PacoteRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ViagemApplication")

public class PacoteController {
	
	
	@Autowired
	private PacoteRepository pacoteRepository;
	
	
	//READ ou GET all
	
	@GetMapping("/pacote")
	public List<Pacote> getAllPacote(){
		return pacoteRepository.findAll();
	}
	
	//READ ou GET by id
	
	@GetMapping("/pacote")
	public ResponseEntity<Pacote> getClienteById(@PathVariable Long id){
		Pacote pacote = pacoteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente inexistente"));
		return ResponseEntity.ok(pacote);
	}
	
	//POST ou CREATE
	@PostMapping("/pacote")
	public Pacote createCliente(@RequestBody Pacote pacote) {
		return pacoteRepository.save(pacote);
	}
	
	
	
	//PUT ou UPDATE
	@PutMapping("/id_pacote/{id}")
	public ResponseEntity<Pacote> updateCliente(@PathVariable Long id, @RequestBody Pacote pacotesDetails){
		
		Pacote pacote = pacoteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pacote Inexistente"));
		
		pacote.setIdPacote(pacotesDetails.getIdPacote());
		pacote.setIdPassageiro(pacotesDetails.getIdPassageiro());
		pacote.setDataViagem(pacotesDetails.getDataViagem());
		pacote.setDataHora(pacotesDetails.getDataHora());
		pacote.setDestino(pacotesDetails.getDestino());
		pacote.setOrigem(pacotesDetails.getOrigem());
		
		Pacote newPacote = pacoteRepository.save(pacote);
		
		return ResponseEntity.ok(newPacote);
	}
	
	//DELETE
	@DeleteMapping("/id_pacote/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePacote(@PathVariable Long id){
		
		Pacote pacote = pacoteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pacote Inexistente"));
		
		pacoteRepository.delete(pacote);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	

}
