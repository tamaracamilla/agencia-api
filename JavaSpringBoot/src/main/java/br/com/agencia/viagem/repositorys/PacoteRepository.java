package br.com.agencia.viagem.repositorys;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agencia.viagem.entities.Pacote;

@Repository

public interface PacoteRepository extends JpaRepository<Pacote, Long> {

}
