package com.login.securit.controller;

import com.login.securit.dto.SecDto;
import lombok.RequiredArgsConstructor;
import com.login.securit.mapper.SecMapper;
import com.login.securit.Entity.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.login.securit.service.ServiceSec;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class SecController {
    private final ServiceSec serviceSec;
    private final SecMapper secMapper;

    @PostMapping
    public ResponseEntity<SecDto> cadastrar(@RequestBody SecDto dto){
        SecDto salvo = serviceSec.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
    @GetMapping("/perfil")
    public ResponseEntity<SecDto> buscarUsuarioAutenticado(Authentication authentication){
        String emailLogado = authentication.getName();
        SecDto usuarioDto = serviceSec.buscarPorEmail(emailLogado);
        return ResponseEntity.ok(usuarioDto);
    }
    }

