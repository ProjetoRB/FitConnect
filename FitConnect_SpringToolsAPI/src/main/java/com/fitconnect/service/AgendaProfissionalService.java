package com.fitconnect.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitconnect.dto.AgendaProfissionalRequestDTO;
import com.fitconnect.dto.AgendaProfissionalResponseDTO;
import com.fitconnect.dto.AgendamentoRequestDTO;
import com.fitconnect.model.AgendaProfissional;
import com.fitconnect.repository.AgendaProfissionalRepository;

@Service
public class AgendaProfissionalService {

    @Autowired
    private AgendaProfissionalRepository repository;

    public AgendaProfissionalResponseDTO cadastrarHorario(
            AgendaProfissionalRequestDTO dto) {

        AgendaProfissional agenda = new AgendaProfissional();

        agenda.setProfissionalId(dto.getProfissionalId());
        agenda.setDataDisponivel(dto.getDataDisponivel());
        agenda.setHoraDisponivel(dto.getHoraDisponivel());
        agenda.setDescricao(dto.getDescricao());
        agenda.setStatusHorario("disponivel");

        AgendaProfissional salvo = repository.save(agenda);

        return converterParaResponse(salvo);
    }

    public List<AgendaProfissionalResponseDTO> listarHorariosDisponiveis(
            Long profissionalId) {

        return repository
                .findByProfissionalIdAndStatusHorario(
                        profissionalId,
                        "disponivel"
                )
                .stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
    }

    public AgendaProfissionalResponseDTO agendarHorario(
            AgendamentoRequestDTO dto) {

        AgendaProfissional horario = repository
                .findById(dto.getHorarioId())
                .orElse(null);

        if (horario == null) {
            return null;
        }

        if (!"disponivel".equalsIgnoreCase(horario.getStatusHorario())) {
            return null;
        }

        horario.setAlunoId(dto.getAlunoId());
        horario.setStatusHorario("agendado");

        AgendaProfissional atualizado = repository.save(horario);

        return converterParaResponse(atualizado);
    }

    
    public List<AgendaProfissionalResponseDTO> listarAgendamentosDoAluno(
            Long alunoId) {

        return repository.findByAlunoId(alunoId)
                .stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
    }

    private AgendaProfissionalResponseDTO converterParaResponse(
            AgendaProfissional agenda) {

        return new AgendaProfissionalResponseDTO(
                agenda.getId(),
                agenda.getProfissionalId(),
                agenda.getAlunoId(),
                agenda.getDataDisponivel(),
                agenda.getHoraDisponivel(),
                agenda.getDescricao(),
                agenda.getStatusHorario()
        );
    }
}