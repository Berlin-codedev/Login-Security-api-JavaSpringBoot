package com.login.securit.mapper;

import com.login.securit.dto.SecDto;
import com.login.securit.Entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class SecMapper {
    public Usuario toEntity(SecDto dto){
        if(dto == null){
            return null;
        }
    Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
    return usuario;

    }
    public SecDto toDto(Usuario usuario){
    if(usuario == null){
        return null;
    }
    SecDto dto = new SecDto();
    dto.setNome(usuario.getNome());
    dto.setEmail(usuario.getEmail());
    return dto;
    }
}
