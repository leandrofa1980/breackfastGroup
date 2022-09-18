package br.com.leandrofa1980.breackfast.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.leandrofa1980.breackfast.entities.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

}
