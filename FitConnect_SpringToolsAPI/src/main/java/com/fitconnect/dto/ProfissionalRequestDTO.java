package com.fitconnect.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ProfissionalRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nomeCompleto;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "A área profissional é obrigatória")
    private String areaProfissional;

    @NotBlank(message = "O documento profissional é obrigatório")
    private String documentoProfissional;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;

    private LocalDate dataNascimento;

    public String getNomeCompleto() { return nomeCompleto; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public String getAreaProfissional() { return areaProfissional; }
    public String getDocumentoProfissional() { return documentoProfissional; }
    public String getSenha() { return senha; }
    public LocalDate getDataNascimento() { return dataNascimento; }
}