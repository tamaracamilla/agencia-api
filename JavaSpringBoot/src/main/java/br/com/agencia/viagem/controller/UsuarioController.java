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
import br.com.agencia.viagem.entities.Usuario;

import br.com.agencia.viagem.repositorys.UsuarioRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ViagemApplication")

public class UsuarioController {


	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	//READ ou GET all
	
	@GetMapping("/usuarios")
	public List<Usuario> getAllPacote(){
		return usuarioRepository.findAll();
	}
	
	//READ ou GET by id
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getClienteById(@PathVariable Long id){
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário inexistente"));
		return ResponseEntity.ok(usuario);
	}
	
	//POST ou CREATE
	@PostMapping("/usuarios")
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
	
	//PUT ou UPDATE
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails){
		
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário Inexistente"));
		
		
		usuario.setNome(usuarioDetails.getNome());
		usuario.setSenha(usuarioDetails.getSenha());
		usuario.setLogin(usuarioDetails.getLogin());
		
		
		Usuario newUsuario = usuarioRepository.save(usuario);
		
		return ResponseEntity.ok(newUsuario);
	}
	
	//DELETE
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUsuario(@PathVariable Long id){
		
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário Inexistente"));
		
		usuarioRepository.delete(usuario);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
