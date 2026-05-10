package com.fitconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fitconnect.model.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    Profissional findByEmailAndSenha(String email, String senha);
}