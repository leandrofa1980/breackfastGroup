package br.com.leandrofa1980.breackfast.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.leandrofa1980.breackfast.dto.ParticipanteDTO;
import br.com.leandrofa1980.breackfast.services.ParticipanteService;

@RestController
@RequestMapping(value = "/participantes")
public class ParticipanteResource {

	@Autowired
	private ParticipanteService service;

	@GetMapping
	public ResponseEntity<Page<ParticipanteDTO>> findAll(Pageable pageable) {
		Page<ParticipanteDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ParticipanteDTO> findById(@PathVariable Long id) {
		ParticipanteDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<ParticipanteDTO> insert(@RequestBody ParticipanteDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ParticipanteDTO> update(@PathVariable Long id, @RequestBody ParticipanteDTO dto) {
		dto = service.update(dto, id);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
