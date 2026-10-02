package com.login.securit.service;

import com.login.securit.dto.SecDto;
import lombok.RequiredArgsConstructor;
import com.login.securit.mapper.SecMapper;
import com.login.securit.Entity.Usuario;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.login.securit.repository.RepositoryJpa;

@Service
@RequiredArgsConstructor
public class ServiceSec {

    private final SecMapper secMapper;
    private final PasswordEncoder passwordEncoder;
    private final RepositoryJpa repositoryJpa;
    @Transactional
    public SecDto cadastrar(SecDto requestDto){
        if (repositoryJpa.existsByEmail(requestDto.getEmail())){
            throw new IllegalArgumentException("Já existe um usuário com este e-mail!");
        }

        Usuario usuario = secMapper.toEntity(requestDto);

        usuario.setSenha(passwordEncoder.encode(requestDto.getSenha()));

        Usuario usuarioSalvo = repositoryJpa.save(usuario);

        return secMapper.toDto(usuarioSalvo);
    }
    @Transactional(readOnly = true)
    public SecDto buscarPorEmail(String email){
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("o e-mail informado é invalido.");
        }
        Usuario usuario;
        usuario = repositoryJpa.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado com esse e-mail: " + email));
        return secMapper.toDto(usuario);
    }
}
