package com.fitconnect.dto;

import java.time.LocalDate;

public class ProfissionalResponseDTO {

    private Long id;
    private String nomeCompleto;
    private String email;
    private String cpf;
    private String areaProfissional;
    private String documentoProfissional;
    private LocalDate dataNascimento;

    public ProfissionalResponseDTO(Long id, String nomeCompleto, String email, String cpf,
            String areaProfissional, String documentoProfissional, LocalDate dataNascimento) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.cpf = cpf;
        this.areaProfissional = areaProfissional;
        this.documentoProfissional = documentoProfissional;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() { return id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public String getAreaProfissional() { return areaProfissional; }
    public String getDocumentoProfissional() { return documentoProfissional; }
    public LocalDate getDataNascimento() { return dataNascimento; }
}