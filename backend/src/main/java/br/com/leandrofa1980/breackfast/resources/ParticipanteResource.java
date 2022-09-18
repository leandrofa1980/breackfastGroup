package br.com.leandrofa1980.breackfast.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
