package br.com.agencia.viagem.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "id_usuario")

public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	 String IdUsuario;
	 String Nome;
	 String Senha;
	 String Login;
	
	

		
		@Column(name = "id_usuario")
		private String idUsuario;
		
		
		@Column(name = "nome")
		private String nome;
		
		@Column(name = "senha")
		private String senha;
		
		@Column(name = "login")
		private String login;
	
		

		public Usuario() {
			super();
		}
	
		public Usuario (long id, String IdUsuario, String  Nome, String  Senha,  String Login) {
			super();
			this.id = id;
			this.idUsuario = IdUsuario;
			this.nome = Nome;
			this.senha = Senha;
			this.login = Login;
			
		
		}
	public void setIdUsuario(String idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Usuario> usuario = new ArrayList<Usuario>();

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setPassageiro(List<Passageiro> passageiro, List<Usuario> usuario) {
		this.usuario = usuario;
	}

	
}
