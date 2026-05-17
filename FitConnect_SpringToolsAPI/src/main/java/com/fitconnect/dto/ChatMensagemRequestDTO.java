package com.fitconnect.dto;

public class ChatMensagemRequestDTO {

    private Long conversaId;
    private Long remetenteId;
    private String remetenteTipo;
    private String mensagem;

    public Long getConversaId() {
        return conversaId;
    }
    
    public Long getRemetenteId() {
        return remetenteId;
    }

    public String getRemetenteTipo() {
        return remetenteTipo;
    }

    public String getMensagem() {
        return mensagem;
    }
}