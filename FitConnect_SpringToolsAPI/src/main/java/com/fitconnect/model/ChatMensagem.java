package com.fitconnect.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "chat_mensagem")
public class ChatMensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "conversa_id")
    private Long conversaId;
    
    @Column(name = "remetente_id")
    private Long remetenteId;

    @Column(name = "remetente_tipo")
    private String remetenteTipo;

    private String mensagem;

    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;

    private Boolean lida;

    public ChatMensagem() {
    }

    @PrePersist
    public void prePersist() {
        dataEnvio = LocalDateTime.now();
        lida = false;
    }

    public Long getId() {
        return id;
    }
    
    public Long getRemetenteId() {
        return remetenteId;
    }

    public Long getConversaId() {
        return conversaId;
    }

    public void setConversaId(Long conversaId) {
        this.conversaId = conversaId;
    }

    public void setRemetenteId(Long remetenteId) {
        this.remetenteId = remetenteId;
    }
    
    public String getRemetenteTipo() {
        return remetenteTipo;
    }

    public void setRemetenteTipo(String remetenteTipo) {
        this.remetenteTipo = remetenteTipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public Boolean getLida() {
        return lida;
    }

    public void setLida(Boolean lida) {
        this.lida = lida;
    }
}