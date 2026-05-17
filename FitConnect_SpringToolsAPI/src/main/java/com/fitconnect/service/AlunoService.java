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
        aluno.setEmail(dto.getEmail());
        aluno.setCpf(dto.getCpf());
        aluno.setPeso(dto.getPeso());
        aluno.setAltura(dto.getAltura());
        aluno.setSexo(dto.getSexo());
        aluno.setSenha(PasswordUtil.criptografar(dto.getSenha()));;

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

        aluno.setNomeCompleto(dto.getNomeCompleto());
        aluno.setEmail(dto.getEmail());
        aluno.setCpf(dto.getCpf());
        aluno.setPeso(dto.getPeso());
        aluno.setAltura(dto.getAltura());
        aluno.setSexo(dto.getSexo());
        aluno.setSenha(PasswordUtil.criptografar(dto.getSenha()));

        Aluno alunoAtualizado = repository.save(aluno);

        return converterParaResponse(alunoAtualizado);
    }

    private AlunoResponseDTO converterParaResponse(Aluno aluno) {
        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNomeCompleto(),
                aluno.getEmail(),
                aluno.getCpf(),
                aluno.getPeso(),
                aluno.getAltura(),
                aluno.getSexo()
        );
    }
}