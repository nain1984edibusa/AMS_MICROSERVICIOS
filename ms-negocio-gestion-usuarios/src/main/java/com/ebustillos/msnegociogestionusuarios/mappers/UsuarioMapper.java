package com.ebustillos.msnegociogestionusuarios.mappers;

import java.util.List;

import com.ebustillos.msnegociogestionusuarios.dto.UsuarioDto;
import com.ebustillos.msnegociogestionusuarios.entity.UsuarioEntity;

public interface UsuarioMapper {

	UsuarioDto toDTO(UsuarioEntity e);
	
	List<UsuarioDto> toDTO(List<UsuarioEntity>lst);
	
}
