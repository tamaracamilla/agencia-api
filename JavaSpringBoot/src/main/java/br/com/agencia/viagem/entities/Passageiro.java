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
@Table(name = "id_passageiro")
public class Passageiro{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	String IdPassageiro;
	String IdUsuario;
	String Cpf;
	String Nome;
	String Telefone1;
	String Telefone2;
	String Email;
	String Cep;
	String Bairro;
	String Numero;
	String Logradouro;

	
	@Column(name = "id_passageiro")
	private String idPassageiro;
	
	
	@Column(name = "id_usuario")
	private String idUsuario;
	
	@Column(name = "cpf")
	private String cpf; 
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telefone1")
	private String telefone1;
	
	@Column(name = "telefone2")
	private String telefone2;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "bairro")
	private String bairro;

	@Column(name = "numero")
	private String numero;

	@Column(name = "logradouro")
	private String logradouro;
	
	
	public Passageiro() {
		super();
	}
	
	
	public Passageiro(long id, String IdUsuario, String IdPassageiro, String Cpf, String  Nome,String  Telefone1, String Telefone2, String  Email,String  Cep, String Bairro, String  Numero, String  Logradouro) {
		super();
		this.id = id;
		this.idUsuario = IdUsuario;
		this.idPassageiro = IdPassageiro;
		this.cpf = Cpf;
		this.nome = Nome;
		this.telefone1 = Telefone1;
		this.telefone2 = Telefone2;
		this.email = Email;
		this.cep = Cep;
		this.bairro = Bairro;
		this.numero = Numero;
		this.logradouro = Logradouro;
		

	}

	public String getIdPassageiro() {
		return this.IdPassageiro;
	}

	public void setIdPassageiro(String idPassageiro) {
		this.IdPassageiro = idPassageiro;
	}

	public String getIdUsuario() {
		return this.IdUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.IdUsuario = idUsuario;
	}

	public String getCpf() {
		return this.Cpf;
	}

	public void setCpf(String cpf) {
		this.Cpf = cpf;
	}

	public String getNome() {
		return this.Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public String getTelefone1() {
		return this.Telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.Telefone1 = telefone1;
	}

	public String getTelefone2() {
		return this.Telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.Telefone2 = telefone2;
	}

	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getCep() {
		return this.Cep;
	}

	public void setCep(String cep) {
		this.Cep = cep;
	}

	public String getBairro() {
		return this.Bairro;
	}

	public void setBairro(String bairro) {
		this.Bairro = bairro;
	}

	public String getNumero() {
		return this.Numero;
	}

	public void setNumero(String numero) {
		this.Numero = numero;
	}

	public String getLogradouro() {
		return this.Logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.Logradouro = logradouro;
	}
	

	
	@JsonIgnore
	@OneToMany(mappedBy = "id_passageiro")
	private List<Pacote> pacotes = new ArrayList<Pacote>();

	public List<Pacote> getPacotes() {
		return pacotes;
	}


	@JsonIgnore
	@OneToMany(mappedBy = "id_passageiro")
	private List<Reserva> reservas = new ArrayList<Reserva>();

	public List<Reserva> getReservas() {
		return reservas;
	}

	
	
	
}