package com.fitconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fitconnect.dto.LoginRequestDTO;
import com.fitconnect.dto.LoginResponseDTO;
import com.fitconnect.service.AuthService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO dto) {

        LoginResponseDTO resposta = service.login(dto);

        if (resposta == null) {
            return ResponseEntity.status(401).body(
                    new LoginResponseDTO(
                            null,
                            null,
                            null,
                            null,
                            "Email ou senha inválidos"
                    )
            );
        }

        return ResponseEntity.ok(resposta);
    }
}