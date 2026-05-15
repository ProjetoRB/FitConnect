package com.fitconnect.dto;

public class AtualizarStatusAgendaDTO {

    private Long horarioId;
    private Long alunoId;
    private String status;

    public Long getHorarioId() {
        return horarioId;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public String getStatus() {
        return status;
    }
}