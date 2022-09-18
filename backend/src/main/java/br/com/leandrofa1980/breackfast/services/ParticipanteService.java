package br.com.leandrofa1980.breackfast.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandrofa1980.breackfast.entities.Participante;
import br.com.leandrofa1980.breackfast.repositories.ParticipanteRepository;

@Service
public class ParticipanteService {
	
	@Autowired
	private ParticipanteRepository repository;
	
	public List<Participante> findAll(){
		return repository.findAll();
	}

}
