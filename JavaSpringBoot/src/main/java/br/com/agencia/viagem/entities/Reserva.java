package br.com.agencia.viagem.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name = "id_reserva")

public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	String IdReserva;
	String IdPassageiro;
	String IdPacote;
	String Nome;
	String Telefone1;
	String Destino;
	String Origem;
	
	@Column(name = "IdReserva")
	private String idReserva;

	@Column(name = "IdPassageiro")
	private String idPassageiro;
	
	
	@Column(columnDefinition = "IdPacote")
	private String idPacote;
	
	@Column(name = "Nome")
	private String nome;
	
	
	@Column(name = "Telefone1")
	private String telefone1;
	
	@Column(name = "Destino")
	private String destino;
	
	@Column(name = "Origem")
	private String origem;
	
	
	public Reserva() {
		super();
	}
	
	public Reserva (long id, String IdPacote,String IdReserva, String IdPassageiro, String  Nome,String  Telefone1,  String Destino, String  Origem) {
		super();
		this.id = id;
		this.idPacote = IdPacote;
		this.idReserva = IdReserva;
		this.idPassageiro = IdPassageiro;
		this.nome = Nome;
		this.telefone1 = Telefone1;
		this.destino = Destino;
		this.origem = Origem;
		
	}
	
		public String getIdReserva() {
			return idReserva;
		}
	
		public void setIdReserva(String idReserva) {
			this.IdReserva = idReserva;
		}
		
		public String getIdPassageiro() {
			return IdPassageiro;
		}

		public void setIdPassageiro(String idPassageiro) {
			this.IdPassageiro = idPassageiro;
		}

		public String getIdPacote() {
			return IdPacote;
		}

		public void setIdPacote(String idPacote) {
			this.IdPacote = idPacote;
		}


		public String getNome() {
			return Nome;
		}

		public void setNome(String nome) {
			this.Nome = nome;
		}

		public String getTelefone1() {
			return Telefone1;
		}

		public void setTelefone1(String telefone1) {
			this.Telefone1 = telefone1;
		}
		
		public String getDestino() {
			return Destino;
		}
		public void setDestino(String destino) {
			this.destino = destino;
		}
		

		public String getOrigem() {
			return Origem;
		}
		public void setOrigem(String origem) {
			this.origem = origem;
		}
		

}
