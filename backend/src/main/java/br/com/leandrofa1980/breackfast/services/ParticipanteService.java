package br.com.leandrofa1980.breackfast.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.leandrofa1980.breackfast.entities.Participante;
import br.com.leandrofa1980.breackfast.repositories.ParticipanteRepository;

@Service
public class ParticipanteService {
	
	@Autowired
	private ParticipanteRepository repository;
		
	@Transactional(readOnly = true)
	public Page<Participante> findAllPaged(Pageable pageable){
		Page<Participante> list = repository.findAll(pageable);
		return list;
	}

	@Transactional(readOnly = true)
	public Participante findById(Long id) {
		Optional<Participante> obj = repository.findById(id);
		Participante entity = obj.get();
		return entity;		
	}
	
	@Transactional
	public Participante insert(Participante obj) {
		Participante entity = new Participante();
		entity.setNome(obj.getNome());
		entity.setCpf(obj.getCpf());
		entity.setOpcao(obj.getOpcao());
		entity = repository.save(entity);
		return entity;		
	}
	
	@Transactional
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
