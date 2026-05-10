package com.fitconnect.dto;

public class ProfissionalResponseDTO {

    private Long id;
    private String nomeCompleto;
    private String email;
    private String cpf;
    private String areaProfissional;
    private String documentoProfissional;

    public ProfissionalResponseDTO(Long id, String nomeCompleto, String email, String cpf, String areaProfissional, String documentoProfissional) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.cpf = cpf;
        this.areaProfissional = areaProfissional;
        this.documentoProfissional = documentoProfissional;
    }

    public Long getId() {
        return id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getAreaProfissional() {
        return areaProfissional;
    }

    public String getDocumentoProfissional() {
        return documentoProfissional;
    }
}