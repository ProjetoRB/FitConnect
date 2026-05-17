package com.fitconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitconnect.model.ChatConversa;

public interface ChatConversaRepository extends JpaRepository<ChatConversa, Long> {

    ChatConversa findByAlunoIdAndProfissionalId(Long alunoId, Long profissionalId);

    List<ChatConversa> findByAlunoId(Long alunoId);

    List<ChatConversa> findByProfissionalId(Long profissionalId);
}