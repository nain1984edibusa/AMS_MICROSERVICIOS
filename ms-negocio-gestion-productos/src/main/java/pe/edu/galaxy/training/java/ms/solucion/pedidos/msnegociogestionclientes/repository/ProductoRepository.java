package pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.entity.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{

	
	//JPQL
	
	@Query("Select p from Producto p where p.estado='1'")
	List<ProductoEntity> findAllCustom();
	
	@Query("Select p from Producto p where upper(p.nombre) like upper(:nombre) and p.estado='1'")
	List<ProductoEntity> findByLikeRazonSocial(@Param("nombre") String razonSocial);

	//SQL
	
	@Modifying
	@Query(nativeQuery = true, value = "update tbl_cliente set estado='0' where cliente_id=:id")
	void deleteCustom(@Param("id") Long id);
	
	
	// Agregates(DTO, Optimizacion de consultas)
}
