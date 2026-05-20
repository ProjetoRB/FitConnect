package com.fitconnect.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitconnect.dto.ProfissionalRequestDTO;
import com.fitconnect.dto.ProfissionalResponseDTO;
import com.fitconnect.model.Profissional;
import com.fitconnect.repository.ProfissionalRepository;
import com.fitconnect.utils.PasswordUtil;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository repository;

    public List<ProfissionalResponseDTO> listarProfissionais() {
        return repository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
    }

    public ProfissionalResponseDTO buscarPorId(Long id) {
        Profissional profissional = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
        return converterParaResponse(profissional);
    }

    public ProfissionalResponseDTO salvarProfissional(ProfissionalRequestDTO dto) {
        Profissional profissional = new Profissional();
        profissional.setNomeCompleto(dto.getNomeCompleto());
        profissional.setEmail(dto.getEmail());
        profissional.setCpf(dto.getCpf());
        profissional.setAreaProfissional(dto.getAreaProfissional());
        profissional.setDocumentoProfissional(dto.getDocumentoProfissional());
        profissional.setSenha(PasswordUtil.criptografar(dto.getSenha()));
        profissional.setDataNascimento(dto.getDataNascimento());

        Profissional salvo = repository.save(profissional);
        return converterParaResponse(salvo);
    }

    public ProfissionalResponseDTO atualizarProfissional(Long id, ProfissionalRequestDTO dto) {
        Profissional profissional = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        if (dto.getNomeCompleto() != null)          profissional.setNomeCompleto(dto.getNomeCompleto());
        if (dto.getEmail() != null)                 profissional.setEmail(dto.getEmail());
        if (dto.getAreaProfissional() != null)      profissional.setAreaProfissional(dto.getAreaProfissional());
        if (dto.getDocumentoProfissional() != null) profissional.setDocumentoProfissional(dto.getDocumentoProfissional());
        if (dto.getDataNascimento() != null)        profissional.setDataNascimento(dto.getDataNascimento());

        if (dto.getSenha() != null && !dto.getSenha().isBlank()) {
            profissional.setSenha(PasswordUtil.criptografar(dto.getSenha()));
        }

        Profissional atualizado = repository.save(profissional);
        return converterParaResponse(atualizado);
    }

    private ProfissionalResponseDTO converterParaResponse(Profissional profissional) {
        return new ProfissionalResponseDTO(
                profissional.getId(),
                profissional.getNomeCompleto(),
                profissional.getEmail(),
                profissional.getCpf(),
                profissional.getAreaProfissional(),
                profissional.getDocumentoProfissional(),
                profissional.getDataNascimento()
        );
    }
}