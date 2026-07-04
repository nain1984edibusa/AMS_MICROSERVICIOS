package com.ebustillos.msnegociogestionusuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ebustillos.msnegociogestionusuarios.dto.UsuarioDto;
import com.ebustillos.msnegociogestionusuarios.mappers.UsuarioMapper;
import com.ebustillos.msnegociogestionusuarios.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	private final UsuarioMapper usuarioMapper;

	@Override
	public List<UsuarioDto> findAll() throws ServiceException {
		
		return this.usuarioMapper.toDTO(this.usuarioRepository.findAll());
	}

	@Override
	public List<UsuarioDto> findByLikeObject(UsuarioDto t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDto save(UsuarioDto t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDto update(UsuarioDto t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<UsuarioDto> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id)
	            .map(usuarioMapper::toDTO); // Si existe, lo mapea; si no, devuelve Optional.empty()
	}

}
