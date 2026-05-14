package com.fitconnect.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendaProfissionalResponseDTO {

    private Long id;
    private Long profissionalId;
    private Long alunoId;
    private LocalDate dataDisponivel;
    private LocalTime horaDisponivel;
    private String descricao;
    private String statusHorario;

    public AgendaProfissionalResponseDTO(
            Long id,
            Long profissionalId,
            Long alunoId,
            LocalDate dataDisponivel,
            LocalTime horaDisponivel,
            String descricao,
            String statusHorario
    ) {
        this.id = id;
        this.profissionalId = profissionalId;
        this.alunoId = alunoId;
        this.dataDisponivel = dataDisponivel;
        this.horaDisponivel = horaDisponivel;
        this.descricao = descricao;
        this.statusHorario = statusHorario;
    }

    public Long getId() {
        return id;
    }

    
    public Long getProfissionalId() {
        return profissionalId;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public LocalDate getDataDisponivel() {
        return dataDisponivel;
    }

    public LocalTime getHoraDisponivel() {
        return horaDisponivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatusHorario() {
        return statusHorario;
    }
}