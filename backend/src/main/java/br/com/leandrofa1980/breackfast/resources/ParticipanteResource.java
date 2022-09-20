package br.com.leandrofa1980.breackfast.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.leandrofa1980.breackfast.entities.Participante;
import br.com.leandrofa1980.breackfast.services.ParticipanteService;

@RestController
@RequestMapping(value = "/participantes")
public class ParticipanteResource {

	@Autowired
	private ParticipanteService service;

	@GetMapping
	public ResponseEntity<Page<Participante>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Participante> list = service.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Participante> findById(@PathVariable Long id) {
		Participante obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Participante> insert(@RequestBody Participante entity) {
		entity = service.insert(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(entity.getId())
				.toUri();
		return ResponseEntity.created(uri).body(entity);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Participante> update(@PathVariable Long id, @RequestBody Participante entity) {
		entity = service.update(entity, id);
		return ResponseEntity.ok().body(entity);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
