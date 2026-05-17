package com.fitconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitconnect.dto.ChatConversaRequestDTO;
import com.fitconnect.dto.ChatMensagemRequestDTO;
import com.fitconnect.model.ChatConversa;
import com.fitconnect.model.ChatMensagem;
import com.fitconnect.repository.ChatConversaRepository;
import com.fitconnect.repository.ChatMensagemRepository;

@Service
public class ChatService {

    @Autowired
    private ChatConversaRepository conversaRepository;

    @Autowired
    private ChatMensagemRepository mensagemRepository;

    public ChatConversa criarOuBuscarConversa(ChatConversaRequestDTO dto) {

        ChatConversa conversaExistente =
                conversaRepository.findByAlunoIdAndProfissionalId(
                        dto.getAlunoId(),
                        dto.getProfissionalId()
                );

        if (conversaExistente != null) {
            return conversaExistente;
        }

        ChatConversa novaConversa = new ChatConversa();
        novaConversa.setAlunoId(dto.getAlunoId());
        novaConversa.setProfissionalId(dto.getProfissionalId());

        return conversaRepository.save(novaConversa);
    }

    public ChatMensagem enviarMensagem(ChatMensagemRequestDTO dto) {

        ChatMensagem mensagem = new ChatMensagem();

        mensagem.setConversaId(dto.getConversaId());
        mensagem.setRemetenteTipo(dto.getRemetenteTipo());
        mensagem.setMensagem(dto.getMensagem());

        return mensagemRepository.save(mensagem);
    }

    public List<ChatMensagem> listarMensagens(Long conversaId) {
        return mensagemRepository.findByConversaIdOrderByDataEnvioAsc(conversaId);
    }

    public List<ChatConversa> listarConversasDoAluno(Long alunoId) {
        return conversaRepository.findByAlunoId(alunoId);
    }

    public List<ChatConversa> listarConversasDoProfissional(Long profissionalId) {
        return conversaRepository.findByProfissionalId(profissionalId);
    }
}