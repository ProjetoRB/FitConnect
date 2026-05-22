package com.fitconnect.dto;

import java.time.LocalDate;

public class ProfissionalResponseDTO {

    private Long id;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String email;
    private String cpf;
    private String sexo;
    private String areaProfissional;
    private String documentoProfissional;

    public ProfissionalResponseDTO(Long id, String nomeCompleto, LocalDate dataNascimento, String email, String cpf, String sexo, String areaProfissional, String documentoProfissional) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.cpf = cpf;
        this.sexo = sexo;
        this.areaProfissional = areaProfissional;
        this.documentoProfissional = documentoProfissional;
    }

    public Long getId() { return id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public String getSexo() { return sexo; }
    public String getAreaProfissional() { return areaProfissional; }
    public String getDocumentoProfissional() { return documentoProfissional; }
}