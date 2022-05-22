package br.com.banco.resources;

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

import br.com.banco.DTOs.TransferenciaDTO;
import br.com.banco.entity.Transferencia;
import br.com.banco.services.TransferenciaService;

	
@RestController
@RequestMapping(value = "/transferencias")
public class TransferenciaResource {
	
	@Autowired
	private TransferenciaService service;
	
	
	@RequestMapping()
	public ResponseEntity<List<Transferencia>> buscarTodos() {
		List<Transferencia> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	
	/*   ********BUSCA PAGINADA************
	
	@GetMapping
	public ResponseEntity<Page<TransferenciaDTO>> findAll(
			
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy
			
			){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<TransferenciaDTO> list = service.findAllPaged(pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	*/
	
	@GetMapping("/{id}")
	public ResponseEntity<TransferenciaDTO> findById(@PathVariable Long id) {
		TransferenciaDTO catDto = service.findById(id);
		return ResponseEntity.ok().body(catDto);
	}
	
	@PostMapping
	public ResponseEntity<TransferenciaDTO> insert(@RequestBody TransferenciaDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TransferenciaDTO> update(@RequestBody TransferenciaDTO dto, @PathVariable Long id) {
		dto = service.update(dto, id);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<TransferenciaDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
