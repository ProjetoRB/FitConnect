package com.fitconnect.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "chat_conversa")
public class ChatConversa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "aluno_id")
    private Long alunoId;

    @Column(name = "profissional_id")
    private Long profissionalId;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "status_conversa")
    private String statusConversa;

    public ChatConversa() {
    }

    @PrePersist
    public void prePersist() {
        dataCriacao = LocalDateTime.now();
        statusConversa = "ativa";
    }

    public Long getId() {
        return id;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getStatusConversa() {
        return statusConversa;
    }

    public void setStatusConversa(String statusConversa) {
        this.statusConversa = statusConversa;
    }
}