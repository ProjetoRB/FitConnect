package com.fitconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitconnect.dto.LoginRequestDTO;
import com.fitconnect.dto.LoginResponseDTO;
import com.fitconnect.model.Aluno;
import com.fitconnect.model.Profissional;
import com.fitconnect.repository.AlunoRepository;
import com.fitconnect.repository.ProfissionalRepository;

@Service
public class AuthService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public LoginResponseDTO login(LoginRequestDTO dto) {

        Aluno aluno = alunoRepository.findByEmailAndSenha(
                dto.getEmail(),
                dto.getSenha()
        );

        if (aluno != null) {
            return new LoginResponseDTO(
                    aluno.getId(),
                    aluno.getNomeCompleto(),
                    aluno.getEmail(),
                    "Aluno",
                    "Login realizado com sucesso"
            );
        }

        Profissional profissional = profissionalRepository.findByEmailAndSenha(
                dto.getEmail(),
                dto.getSenha()
        );

        if (profissional != null) {
            return new LoginResponseDTO(
                    profissional.getId(),
                    profissional.getNomeCompleto(),
                    profissional.getEmail(),
                    "Profissional",
                    "Login realizado com sucesso"
            );
        }

        return null;
    }
}