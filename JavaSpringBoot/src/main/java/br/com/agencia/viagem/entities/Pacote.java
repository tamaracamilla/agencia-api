package br.com.agencia.viagem.entities;

import java.sql.Date;
import java.sql.Time;
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
@Table(name = "id_pacote")

public class Pacote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "id_pacote")
	private String idPacote;
	
	@Column(name = "id_passageiro")
	private String idPassageiro;
	
	@Column(name= "dataViagem")
	private Date dataViagem;
	
	@Column(name = "dataHora")
	private Time dataHora;
	
	@Column(name = "destino")
	private String destino;
	
	@Column(name = "origem")
	private String origem;
	
	
	public Pacote() {
		super();
	}
	
	public Pacote(long id, String IdPacote, String IdPassageiro, Date DataViagem, Time DataHora, String Destino, String Origem) {
		super();
		this.id = id;
		this.idPacote = IdPacote;
		this.idPassageiro = IdPassageiro;
		this.dataViagem = DataViagem;
		this.dataHora = DataHora;
		this.destino = Destino;
		this.origem = Origem;

	}

	public long getId() {
		return this. id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getIdPacote() {
		return this. idPacote;
	}
	public void setIdPacote(String idPacote) {
		this.idPacote = idPacote;
	}
	
	public String getIdPassageiro() {
		return this. idPassageiro;
	}
	public void setIdPassageiro(String idPassageiro) {
		this.idPassageiro = idPassageiro;
	}
	
	public Date getDataViagem() {
		return this. dataViagem;
	}
	public void setDataViagem(Date dataViagem) {
		this.dataViagem = dataViagem;
	}
	
	public Time getDataHora() {
		return this. dataHora;
	}
	public void setDataHora(Time dataHora) {
		this.dataHora = dataHora;
	}
	

	public String getDestino() {
		return this. destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	

	public String getOrigem() {
		return this. origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	


	@JsonIgnore
	@OneToMany(mappedBy = "id_pacote")
	
	private List<Reserva> reservas = new ArrayList<Reserva>();

	public List<Reserva> getReservas() {
		return reservas;
	}

	


}
