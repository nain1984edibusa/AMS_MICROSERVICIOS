package com.ebustillos.msnegociogestionusuarios.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebustillos.msnegociogestionusuarios.dto.UsuarioDto;
import com.ebustillos.msnegociogestionusuarios.services.UsuarioService;
import com.ebustillos.msnegociogestionusuarios.services.ServiceException;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

	private final UsuarioService clienteService;

	public UsuarioController(final UsuarioService clienteService) {
		this.clienteService = clienteService;
	}


	@GetMapping
	public ResponseEntity<List<UsuarioDto>> findAll() throws ServiceException {
		try {
			return ResponseEntity.ok(clienteService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
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