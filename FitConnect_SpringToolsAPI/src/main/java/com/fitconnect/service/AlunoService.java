package com.fitconnect.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitconnect.dto.AlunoRequestDTO;
import com.fitconnect.dto.AlunoResponseDTO;
import com.fitconnect.model.Aluno;
import com.fitconnect.repository.AlunoRepository;
import com.fitconnect.utils.PasswordUtil;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public List<AlunoResponseDTO> listarAlunos() {
        return repository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
    }

    public AlunoResponseDTO salvarAluno(AlunoRequestDTO dto) {
        Aluno aluno = new Aluno();

        aluno.setNomeCompleto(dto.getNomeCompleto());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setEmail(dto.getEmail());
        aluno.setCpf(dto.getCpf());
        aluno.setPeso(dto.getPeso());
        aluno.setAltura(dto.getAltura());
        aluno.setSexo(dto.getSexo());
        aluno.setSenha(PasswordUtil.criptografar(dto.getSenha()));

        Aluno alunoSalvo = repository.save(aluno);

        return converterParaResponse(alunoSalvo);
    }

    public AlunoResponseDTO buscarPorId(Long id) {
        Aluno aluno = repository.findById(id).orElse(null);

        if (aluno == null) {
            return null;
        }

        return converterParaResponse(aluno);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public AlunoResponseDTO atualizarAluno(Long id, AlunoRequestDTO dto) {
        Aluno aluno = repository.findById(id).orElse(null);

        if (aluno == null) {
            return null;
        }

        if (dto.getNomeCompleto() != null) aluno.setNomeCompleto(dto.getNomeCompleto());
        if (dto.getDataNascimento() != null) aluno.setDataNascimento(dto.getDataNascimento());
        if (dto.getEmail() != null) aluno.setEmail(dto.getEmail());
        if (dto.getCpf() != null) aluno.setCpf(dto.getCpf());
        if (dto.getSexo() != null) aluno.setSexo(dto.getSexo());
        if (dto.getPeso() != null) aluno.setPeso(dto.getPeso());
        if (dto.getAltura() != null) aluno.setAltura(dto.getAltura());
        if (dto.getSenha() != null && !dto.getSenha().isBlank()) {
            aluno.setSenha(PasswordUtil.criptografar(dto.getSenha()));
        }

        Aluno alunoAtualizado = repository.save(aluno);
        return converterParaResponse(alunoAtualizado);
    }

    private AlunoResponseDTO converterParaResponse(Aluno aluno) {
        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNomeCompleto(),
                aluno.getDataNascimento(),
                aluno.getEmail(),
                aluno.getCpf(),
                aluno.getPeso(),
                aluno.getAltura(),
                aluno.getSexo() 
        );
    }
}