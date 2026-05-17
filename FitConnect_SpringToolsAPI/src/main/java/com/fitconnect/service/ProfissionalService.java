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

    public ProfissionalResponseDTO salvarProfissional(ProfissionalRequestDTO dto) {
        Profissional profissional = new Profissional();

        profissional.setNomeCompleto(dto.getNomeCompleto());
        profissional.setEmail(dto.getEmail());
        profissional.setCpf(dto.getCpf());
        profissional.setAreaProfissional(dto.getAreaProfissional());
        profissional.setDocumentoProfissional(dto.getDocumentoProfissional());
        profissional.setSenha(PasswordUtil.criptografar(dto.getSenha()));

        Profissional salvo = repository.save(profissional);

        return converterParaResponse(salvo);
    }

    private ProfissionalResponseDTO converterParaResponse(Profissional profissional) {
        return new ProfissionalResponseDTO(
                profissional.getId(),
                profissional.getNomeCompleto(),
                profissional.getEmail(),
                profissional.getCpf(),
                profissional.getAreaProfissional(),
                profissional.getDocumentoProfissional()
        );
    }
}