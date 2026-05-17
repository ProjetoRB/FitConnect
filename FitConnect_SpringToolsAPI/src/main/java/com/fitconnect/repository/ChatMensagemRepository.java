package com.fitconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitconnect.model.ChatMensagem;

public interface ChatMensagemRepository extends JpaRepository<ChatMensagem, Long> {

    List<ChatMensagem> findByConversaIdOrderByDataEnvioAsc(Long conversaId);
}