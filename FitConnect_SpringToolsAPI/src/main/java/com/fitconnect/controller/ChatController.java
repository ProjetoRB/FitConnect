package com.fitconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fitconnect.dto.ChatConversaRequestDTO;
import com.fitconnect.dto.ChatMensagemRequestDTO;
import com.fitconnect.model.ChatConversa;
import com.fitconnect.model.ChatMensagem;
import com.fitconnect.service.ChatService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService service;

    @PostMapping("/conversa")
    public ResponseEntity<ChatConversa> criarOuBuscarConversa(
            @RequestBody ChatConversaRequestDTO dto) {

        return ResponseEntity.ok(
                service.criarOuBuscarConversa(dto)
        );
    }

    @PostMapping("/mensagem")
    public ResponseEntity<ChatMensagem> enviarMensagem(
            @RequestBody ChatMensagemRequestDTO dto) {

        return ResponseEntity.ok(
                service.enviarMensagem(dto)
        );
    }

    @GetMapping("/mensagens/{conversaId}")
    public ResponseEntity<List<ChatMensagem>> listarMensagens(
            @PathVariable Long conversaId) {

        return ResponseEntity.ok(
                service.listarMensagens(conversaId)
        );
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<ChatConversa>> listarConversasDoAluno(
            @PathVariable Long alunoId) {

        return ResponseEntity.ok(
                service.listarConversasDoAluno(alunoId)
        );
    }

    @GetMapping("/profissional/{profissionalId}")
    public ResponseEntity<List<ChatConversa>> listarConversasDoProfissional(
            @PathVariable Long profissionalId) {

        return ResponseEntity.ok(
                service.listarConversasDoProfissional(profissionalId)
        );
    }
}