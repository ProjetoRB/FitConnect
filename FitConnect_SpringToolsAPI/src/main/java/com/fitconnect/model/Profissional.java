package com.fitconnect.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;
    private String email;
    private String cpf;
    private String areaProfissional;
    private String documentoProfissional;
    private String senha;

    @Column(nullable = true)
    private LocalDate dataNascimento;

    public Profissional() {}

    public Profissional(Long id, String nomeCompleto, String email, String cpf,
            String areaProfissional, String documentoProfissional, String senha,
            LocalDate dataNascimento) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.cpf = cpf;
        this.areaProfissional = areaProfissional;
        this.documentoProfissional = documentoProfissional;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() { return id; }

    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getAreaProfissional() { return areaProfissional; }
    public void setAreaProfissional(String areaProfissional) { this.areaProfissional = areaProfissional; }

    public String getDocumentoProfissional() { return documentoProfissional; }
    public void setDocumentoProfissional(String documentoProfissional) { this.documentoProfissional = documentoProfissional; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
}