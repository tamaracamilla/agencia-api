package br.com.agencia.viagem.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agencia.viagem.entities.Reserva;

@Repository

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
