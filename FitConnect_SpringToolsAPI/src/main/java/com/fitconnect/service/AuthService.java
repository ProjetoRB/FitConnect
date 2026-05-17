package com.fitconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitconnect.dto.LoginRequestDTO;
import com.fitconnect.dto.LoginResponseDTO;
import com.fitconnect.model.Aluno;
import com.fitconnect.model.Profissional;
import com.fitconnect.repository.AlunoRepository;
import com.fitconnect.repository.ProfissionalRepository;
import com.fitconnect.utils.PasswordUtil;

@Service
public class AuthService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public LoginResponseDTO login(LoginRequestDTO dto) {

        Aluno aluno = alunoRepository.findByEmail(dto.getEmail());

        if (
            aluno != null &&
            PasswordUtil.verificar(dto.getSenha(), aluno.getSenha())
        ) {
            return new LoginResponseDTO(
                    aluno.getId(),
                    aluno.getNomeCompleto(),
                    aluno.getEmail(),
                    "Aluno",
                    "Login realizado com sucesso"
            );
        }

        Profissional profissional = profissionalRepository.findByEmail(dto.getEmail());

        if (
            profissional != null &&
            PasswordUtil.verificar(dto.getSenha(), profissional.getSenha())
        ) {
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