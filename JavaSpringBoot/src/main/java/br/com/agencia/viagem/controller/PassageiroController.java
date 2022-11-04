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
import br.com.agencia.viagem.entities.Passageiro;
import br.com.agencia.viagem.repositorys.PassageiroRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ViagemApplication")
public class PassageiroController {
	
	@Autowired
	private PassageiroRepository passageiroRepository;
	
	
	//READ ou GET all
	
	@GetMapping("/passageiros")
	public List<Passageiro> getAllPacote(){
		return passageiroRepository.findAll();
	}
	
	//READ ou GET by id
	
	@GetMapping("/passageiros/{id}")
	public ResponseEntity<Passageiro> getPassageiroById(@PathVariable Long id){
		Passageiro passageiro = passageiroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Passageiro inexistente"));
		return ResponseEntity.ok(passageiro);
	}
	
	//POST ou CREATE
	@PostMapping("/passageiros")
	public Passageiro createPassageiro(@RequestBody Passageiro passageiro) {
		return passageiroRepository.save(passageiro);
	}
	
	
	
	//PUT ou UPDATE
	@PutMapping("/passageiros/{id}")
	public ResponseEntity<Passageiro> updatePassageiro(@PathVariable Long id, @RequestBody Passageiro passageiroDetails){
		
		Passageiro passageiro = passageiroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Passageiro Inexistente"));
		
		passageiro.setIdPassageiro(passageiroDetails.getIdPassageiro());
		passageiro.setCpf(passageiroDetails.getCpf());
		passageiro.setNome(passageiroDetails.getNome());
		passageiro.setTelefone1(passageiroDetails.getTelefone1());
		passageiro.setTelefone2(passageiroDetails.getTelefone2());
		passageiro.setEmail(passageiroDetails.getEmail());
		passageiro.setCep(passageiroDetails.getCep());
		passageiro.setBairro(passageiroDetails.getBairro());
		passageiro.setNumero(passageiroDetails.getNumero());
		passageiro.setLogradouro(passageiroDetails.getLogradouro());
		
		
		return ResponseEntity.ok(createPassageiro(null));
	}
	
	//DELETE
	@DeleteMapping("/passageiros/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePacote(@PathVariable Long id){
		
		Passageiro passageiro = passageiroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pacote Inexistente"));
		
		passageiroRepository.delete(passageiro);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	public PassageiroRepository getPassageiroRepository() {
		return passageiroRepository;
	}

	public void setPassageiroRepository(PassageiroRepository passageiroRepository) {
		this.passageiroRepository = passageiroRepository;
	}
	
	


}
