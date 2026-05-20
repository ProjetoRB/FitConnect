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

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalResponseDTO> buscarPorId(@PathVariable Long id) {
        ProfissionalResponseDTO profissional = service.buscarPorId(id);
        return ResponseEntity.ok(profissional);
    }

    @PostMapping
    public ResponseEntity<ProfissionalResponseDTO> salvar(
            @Valid @RequestBody ProfissionalRequestDTO dto) {
        ProfissionalResponseDTO profissionalSalvo = service.salvarProfissional(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(profissionalSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody ProfissionalRequestDTO dto) {
        ProfissionalResponseDTO atualizado = service.atualizarProfissional(id, dto);
        return ResponseEntity.ok(atualizado);
    }
}