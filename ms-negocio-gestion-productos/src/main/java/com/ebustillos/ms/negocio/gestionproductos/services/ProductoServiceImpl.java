package com.ebustillos.ms.negocio.gestionproductos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.ebustillos.ms.negocio.gestionproductos.dto.ProductoDTO;
import com.ebustillos.ms.negocio.gestionproductos.mappers.ProductoMapper;
import com.ebustillos.ms.negocio.gestionproductos.repository.ProductoRepository;

@RequiredArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {
	
	private final ProductoRepository productoRepository;
	private final ProductoMapper productoMapper;

	@Override
	public List<ProductoDTO> findAll() throws ServiceException {
		
		return this.productoMapper.toDTO(this.productoRepository.findAll());
	}

	@Override
	public List<ProductoDTO> findByLikeObject(ProductoDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoDTO save(ProductoDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoDTO update(ProductoDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<ProductoDTO> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return productoRepository.findById(id)
	            .map(productoMapper::toDTO); //
	}

}
