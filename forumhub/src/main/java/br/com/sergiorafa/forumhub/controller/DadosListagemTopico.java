package br.com.sergiorafa.forumhub.controller;

import br.com.sergiorafa.forumhub.model.Topico;

import java.time.LocalDateTime;

// DTO para listagem de tópicos
public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao
) {
    // Construtor para criar o DTO a partir da entidade Topico
    public DadosListagemTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao()
        );
    }
}

