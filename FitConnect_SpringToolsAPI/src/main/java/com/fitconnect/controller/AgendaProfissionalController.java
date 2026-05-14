package com.fitconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fitconnect.dto.AgendaProfissionalRequestDTO;
import com.fitconnect.dto.AgendaProfissionalResponseDTO;
import com.fitconnect.dto.AgendamentoRequestDTO;
import com.fitconnect.service.AgendaProfissionalService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/agenda-profissional")
public class AgendaProfissionalController {

    @Autowired
    private AgendaProfissionalService service;

    // ------------------------
    // CADASTRAR HORÁRIO DISPONÍVEL
    // ------------------------
    @PostMapping
    public ResponseEntity<AgendaProfissionalResponseDTO> cadastrarHorario(
            @RequestBody AgendaProfissionalRequestDTO dto) {

        AgendaProfissionalResponseDTO resposta =
                service.cadastrarHorario(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resposta);
    }

    // ------------------------
    // LISTAR HORÁRIOS DISPONÍVEIS
    // ------------------------
    @GetMapping("/profissional/{profissionalId}")
    public ResponseEntity<List<AgendaProfissionalResponseDTO>>
    listarHorariosDisponiveis(
            @PathVariable Long profissionalId) {

        return ResponseEntity.ok(
                service.listarHorariosDisponiveis(profissionalId)
        );
    }

    // ------------------------
    // AGENDAR HORÁRIO
    // ------------------------
    @PutMapping("/agendar")
    public ResponseEntity<AgendaProfissionalResponseDTO>
    agendarHorario(
            @RequestBody AgendamentoRequestDTO dto) {

        AgendaProfissionalResponseDTO resposta =
                service.agendarHorario(dto);

        if (resposta == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(resposta);
    }

    // ------------------------
    // LISTAR AGENDAMENTOS DO ALUNO
    // ------------------------
    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<AgendaProfissionalResponseDTO>>
    listarAgendamentosDoAluno(
            @PathVariable Long alunoId) {

        return ResponseEntity.ok(
                service.listarAgendamentosDoAluno(alunoId)
        );
    }
}