package com.fitconnect.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public class AlunoRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nomeCompleto;
    
    private LocalDate dataNascimento;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;

    private String peso;
    private String altura;
    private String sexo;
    private String senha;

    public String getNomeCompleto() { return nomeCompleto; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public String getSexo() { return sexo; }
    public String getPeso() { return peso; }
    public String getAltura() { return altura; }
    public String getSenha() { return senha; }
}