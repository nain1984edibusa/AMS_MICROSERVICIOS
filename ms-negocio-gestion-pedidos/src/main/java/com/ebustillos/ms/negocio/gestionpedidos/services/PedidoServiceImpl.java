package com.ebustillos.ms.negocio.gestionpedidos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.ebustillos.ms.negocio.gestionpedidos.dto.*;
import com.ebustillos.ms.negocio.gestionpedidos.entity.PedidoEntity;
import com.ebustillos.ms.negocio.gestionpedidos.mappers.*;
import com.ebustillos.ms.negocio.gestionpedidos.repository.*;
import com.ebustillos.ms.negocio.gestionpedidos.services.client.clientes.ClienteDto;
import com.ebustillos.ms.negocio.gestionpedidos.services.client.clientes.ClienteService;

@Service
public class PedidoServiceImpl implements PedidoService {

	private final PedidoRepository pedidoRepository;
	private final PedidoMapper pedidoMapper;
	private final ClienteService clienteService;

	public PedidoServiceImpl(final PedidoRepository pedidoRepository, final PedidoMapper pedidoMapper, final ClienteService clienteService) {
		this.pedidoRepository = pedidoRepository;
		this.pedidoMapper = pedidoMapper;
		this.clienteService = clienteService;
	}
	
	@Override
		public Optional<PedidoDto> findById(Long id) throws ServiceException {
		try {
			Optional<PedidoEntity> optPedidoEntity =  pedidoRepository.findById(id);
			if (optPedidoEntity.isPresent()) {
				PedidoEntity pedidoEntity = optPedidoEntity.get();
				PedidoDto pedidoDto = pedidoMapper.toDTO(pedidoEntity); 
				ClienteDto clienteDTO = clienteService.findById(pedidoDto.getIdCliente());
				
				pedidoDto.setClienteDTO(clienteDTO);

				return Optional.ofNullable(pedidoDto);
			}
			return null;

		} catch (Exception e) {
			throw new ServiceException();
		}
	}
//	public Optional<PedidoDto> findById(Long id) throws ServiceException {
//		// TODO Auto-generated method stub
//				return pedidoRepository.findById(id)
//			            .map(pedidoMapper::toDTO); // Si existe, lo mapea; si no, devuelve Optional.empty()
//	}

	@Override
	public List<PedidoDto> findAll() throws ServiceException {

		return this.pedidoMapper.toDTO(this.pedidoRepository.findAll());
	}

	@Override
	public List<PedidoDto> findByLikeObject(PedidoDto t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoDto save(PedidoDto t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoDto update(PedidoDto t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws ServiceException {
		// TODO Auto-generated method stub

	}

}
