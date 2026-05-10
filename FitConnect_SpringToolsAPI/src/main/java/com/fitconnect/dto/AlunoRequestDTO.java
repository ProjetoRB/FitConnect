package com.fitconnect.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AlunoRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nomeCompleto;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;

    private String peso;
    private String altura;
    private String sexo;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;

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

    public String getSenha() {
        return senha;
    }
}