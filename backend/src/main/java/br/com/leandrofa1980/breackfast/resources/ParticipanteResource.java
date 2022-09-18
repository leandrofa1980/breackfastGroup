package br.com.leandrofa1980.breackfast.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.leandrofa1980.breackfast.entities.Participante;
import br.com.leandrofa1980.breackfast.services.ParticipanteService;

@RestController
@RequestMapping(value = "/participantes")
public class ParticipanteResource {
	
	@Autowired
	private ParticipanteService service;
	
	@GetMapping
	public ResponseEntity<List<Participante>> findAll(){
		List<Participante> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Participante> findById(@PathVariable Long id){
		Participante obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Participante> insert(@RequestBody Participante entity){
		entity = service.insert(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).body(entity);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Participante> update(@PathVariable Long id, @RequestBody Participante entity){
		entity = service.update(entity, id);
		return ResponseEntity.ok().body(entity);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
