package com.ebustillos.msnegociogestionusuarios.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ebustillos.msnegociogestionusuarios.dto.UsuarioDto;
import com.ebustillos.msnegociogestionusuarios.entity.UsuarioEntity;


@Component
public class UsuarioMapperImpl implements UsuarioMapper {

	@Override
	public UsuarioDto toDTO(UsuarioEntity e) {
		return UsuarioDto.builder()
							.id(e.getId())
							.name(e.getName())
							.lastName(e.getLastName()).build();
	}

	@Override
	public List<UsuarioDto> toDTO(List<UsuarioEntity> lst) {
		return lst.stream().map(e -> toDTO(e)).toList();
	}

}
