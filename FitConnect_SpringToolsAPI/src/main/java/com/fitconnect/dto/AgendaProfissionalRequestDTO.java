package com.fitconnect.dto;


import java.time.LocalDate;
import java.time.LocalTime;

public class AgendaProfissionalRequestDTO {

    private Long profissionalId;
    private LocalDate dataDisponivel;
    private LocalTime horaDisponivel;
    private String descricao;

    public Long getProfissionalId() {
        return profissionalId;
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
}