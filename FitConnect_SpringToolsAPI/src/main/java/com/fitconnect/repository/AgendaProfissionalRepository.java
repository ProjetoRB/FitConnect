package com.fitconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitconnect.model.AgendaProfissional;

public interface AgendaProfissionalRepository extends JpaRepository<AgendaProfissional, Long> {

    List<AgendaProfissional> findByProfissionalIdAndStatusHorario(
            Long profissionalId,
            String statusHorario
    );

    List<AgendaProfissional> findByAlunoId(Long alunoId);
}