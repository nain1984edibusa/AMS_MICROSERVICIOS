package pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.dto.ProductoDTO;
import pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.services.ProductoService;
import pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.services.ServiceException;

@RestController
@RequestMapping("api/v1/productos")
public class ProductoController {

	private final ProductoService productosService;

	public ProductoController(final ProductoService productosService) {
		this.productosService = productosService;
	}

	@GetMapping
	public ResponseEntity<List<ProductoDTO>> findAll() throws ServiceException {
		try {
			return ResponseEntity.ok(productosService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<ProductoDTO> findById(@PathVariable("id") Long id) throws ServiceException {
	     return productosService.findById(id)
	             .map(ResponseEntity::ok)
	             .orElseGet(() -> ResponseEntity.notFound().build());
	 }

	/*
	 * 
	 * @GetMapping
		public List<ProductoDTO> findAll() throws ServiceException {
		return productosService.findAll();
		}
	 * @GetMapping("/by-razonSocial") public List<ProductoEntity>
	 * findByLikeRazonSocial(@RequestParam String razonSocial) { return
	 * productosService.findByLikeRazonSocial(razonSocial); }
	 * 
	 * @GetMapping("/{id}") public Optional<ProductoEntity> findById(@PathVariable
	 * Long id) { return productosService.findById(id); }
	 * 
	 * @PostMapping public ProductoEntity save(@RequestBody ProductoEntity
	 * productosEntity) { return productosService.save(productosEntity); }
	 * 
	 * @PutMapping("/{id}") public ProductoEntity update(@PathVariable Long
	 * id, @RequestBody ProductoEntity productosEntity) { productosEntity.setId(id);
	 * return productosService.update(productosEntity); }
	 * 
	 * @DeleteMapping("/{id}") public void delete(@PathVariable Long id) {
	 * productosService.delete(id); }
	 */
}