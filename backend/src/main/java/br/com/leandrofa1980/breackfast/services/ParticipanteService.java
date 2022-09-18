package br.com.leandrofa1980.breackfast.services;

import java.util.List;
import java.util.Optional;

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

	public Participante findById(Long id) {
		Optional<Participante> obj = repository.findById(id);
		Participante entity = obj.get();
		return entity;		
	}
	
	public Participante insert(Participante obj) {
		Participante entity = new Participante();
		entity.setNome(obj.getNome());
		entity.setCpf(obj.getCpf());
		entity.setOpcao(obj.getOpcao());
		entity = repository.save(entity);
		return entity;		
	}
	
	public Participante update(Participante obj, Long id) {
		Participante entity = repository.getReferenceById(id);
		entity.setNome(obj.getNome());
		entity.setCpf(obj.getCpf());
		entity.setOpcao(obj.getOpcao());
		entity = repository.save(entity);
		return entity;
	}

	public void deleteById(long id) {
		repository.deleteById(id);		
	}

}
