package com.fitconnect.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "agenda_profissional")
public class AgendaProfissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profissional_id")
    private Long profissionalId;

    @Column(name = "aluno_id")
    private Long alunoId;

    @Column(name = "data_disponivel")
    private LocalDate dataDisponivel;

    @Column(name = "hora_disponivel")
    private LocalTime horaDisponivel;

    private String descricao;

    @Column(name = "status_horario")
    private String statusHorario;

    public AgendaProfissional() {
    }

    public Long getId() {
        return id;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public LocalDate getDataDisponivel() {
        return dataDisponivel;
    }

    public void setDataDisponivel(LocalDate dataDisponivel) {
        this.dataDisponivel = dataDisponivel;
    }

    public LocalTime getHoraDisponivel() {
        return horaDisponivel;
    }

    public void setHoraDisponivel(LocalTime horaDisponivel) {
        this.horaDisponivel = horaDisponivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatusHorario() {
        return statusHorario;
    }

    public void setStatusHorario(String statusHorario) {
        this.statusHorario = statusHorario;
    }
}