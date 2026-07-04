package pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.dto.ClienteDTO;
import pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.mappers.ClienteMapper;
import pe.edu.galaxy.training.java.ms.solucion.pedidos.msnegociogestionclientes.repository.ClienteRepository;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {
	
	private final ClienteRepository clienteRepository;
	private final ClienteMapper clienteMapper;

	@Override
	public List<ClienteDTO> findAll() throws ServiceException {
		
		return this.clienteMapper.toDTO(this.clienteRepository.findAll());
	}

	@Override
	public List<ClienteDTO> findByLikeObject(ClienteDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteDTO save(ClienteDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteDTO update(ClienteDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<ClienteDTO> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id)
	            .map(clienteMapper::toDTO); // Si existe, lo mapea; si no, devuelve Optional.empty()
	}

}
