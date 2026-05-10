package com.fitconnect.dto;

public class AlunoResponseDTO {

    private Long id;
    private String nomeCompleto;
    private String email;
    private String cpf;
    private String peso;
    private String altura;
    private String sexo;

    public AlunoResponseDTO(Long id, String nomeCompleto, String email, String cpf, String peso, String altura, String sexo) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.cpf = cpf;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
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

    public String getPeso() {
        return peso;
    }

    public String getAltura() {
        return altura;
    }

    public String getSexo() {
        return sexo;
    }
}