package br.com.leandrofa1980.breackfast.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.leandrofa1980.breackfast.dto.ParticipanteDTO;
import br.com.leandrofa1980.breackfast.entities.Participante;
import br.com.leandrofa1980.breackfast.repositories.ParticipanteRepository;

@Service
public class ParticipanteService {
	
	@Autowired
	private ParticipanteRepository repository;
		
	@Transactional(readOnly = true)
	public Page<ParticipanteDTO> findAllPaged(Pageable pageable){
		Page<Participante> list = repository.findAll(pageable);
		return list.map(x -> new ParticipanteDTO(x));
	}

	@Transactional(readOnly = true)
	public ParticipanteDTO findById(Long id) {
		Optional<Participante> dto = repository.findById(id);
		Participante entity = dto.get();
		return new ParticipanteDTO(entity);		
	}
	
	@Transactional
	public ParticipanteDTO insert(ParticipanteDTO dto) {
		Participante entity = new Participante();
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setOpcao(dto.getOpcao());
		entity = repository.save(entity);
		return new ParticipanteDTO(entity);		
	}
	
	@Transactional
	public ParticipanteDTO update(ParticipanteDTO dto, Long id) {
		Participante entity = repository.getReferenceById(id);
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setOpcao(dto.getOpcao());
		entity = repository.save(entity);
		return new ParticipanteDTO(entity);
	}

	public void deleteById(long id) {
		repository.deleteById(id);		
	}

}
