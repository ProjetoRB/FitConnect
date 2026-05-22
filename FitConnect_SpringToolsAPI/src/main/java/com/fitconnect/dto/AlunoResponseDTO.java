package com.fitconnect.dto;

import java.time.LocalDate;

public class AlunoResponseDTO {

    private Long id;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String email;
    private String cpf;
    private String sexo;
    private String peso;
    private String altura;

    public AlunoResponseDTO(Long id, String nomeCompleto, LocalDate dataNascimento, String email, String cpf, String peso, String altura, String sexo) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.cpf = cpf;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
    }

    public Long getId() { return id; }
    public String getNomeCompleto() { return nomeCompleto; }    
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public String getSexo() { return sexo; }
    public String getPeso() { return peso; }
    public String getAltura() { return altura; }
}