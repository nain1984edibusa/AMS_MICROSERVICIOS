package com.ebustillos.ms.negocio.gestionclientes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ebustillos.ms.negocio.gestionclientes.dto.ClienteDTO;
import com.ebustillos.ms.negocio.gestionclientes.services.ClienteService;
import com.ebustillos.ms.negocio.gestionclientes.services.ServiceException;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

	private final ClienteService clienteService;

	public ClienteController(final ClienteService clienteService) {
		this.clienteService = clienteService;
	}


	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() throws ServiceException {
		try {
			return ResponseEntity.ok(clienteService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<ClienteDTO> findById(@PathVariable("id") Long id) throws ServiceException {
	     return clienteService.findById(id)
	             .map(ResponseEntity::ok)
	             .orElseGet(() -> ResponseEntity.notFound().build());
	 }
	 
	/*
	 * @GetMapping("/by-razonSocial") public List<ClienteEntity>
	 * findByLikeRazonSocial(@RequestParam String razonSocial) { return
	 * clienteService.findByLikeRazonSocial(razonSocial); }
	 * 
	 * @GetMapping("/{id}") public Optional<ClienteEntity> findById(@PathVariable
	 * Long id) { return clienteService.findById(id); }
	 * 
	 * @PostMapping public ClienteEntity save(@RequestBody ClienteEntity
	 * clienteEntity) { return clienteService.save(clienteEntity); }
	 * 
	 * @PutMapping("/{id}") public ClienteEntity update(@PathVariable Long
	 * id, @RequestBody ClienteEntity clienteEntity) { clienteEntity.setId(id);
	 * return clienteService.update(clienteEntity); }
	 * 
	 * @DeleteMapping("/{id}") public void delete(@PathVariable Long id) {
	 * clienteService.delete(id); }
	 */
}