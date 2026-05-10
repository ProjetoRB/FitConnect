package com.fitconnect.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fitconnect.dto.ProfissionalRequestDTO;
import com.fitconnect.dto.ProfissionalResponseDTO;
import com.fitconnect.service.ProfissionalService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService service;

    @GetMapping
    public ResponseEntity<List<ProfissionalResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarProfissionais());
    }

    @PostMapping
    public ResponseEntity<ProfissionalResponseDTO> salvar(
            @Valid @RequestBody ProfissionalRequestDTO dto) {

        ProfissionalResponseDTO profissionalSalvo = service.salvarProfissional(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(profissionalSalvo);
    }
}