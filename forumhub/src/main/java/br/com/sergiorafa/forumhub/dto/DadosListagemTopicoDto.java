package br.com.sergiorafa.forumhub.dto;


import br.com.sergiorafa.forumhub.model.Topico; // Importação correta da entidade Topico
import java.time.LocalDateTime;

/**
 * DTO para listar os dados de um tópico.
 * Utiliza o construtor para extrair dados específicos da entidade Topico para uma visão simplificada.
 */
public record DadosListagemTopicoDto(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao
) {
    /**
     * Construtor para criar o DTO a partir da entidade Topico.
     *
     * @param topico A entidade Topico da qual os dados serão extraídos.
     */
    public DadosListagemTopicoDto(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao()
        );
    }
}

