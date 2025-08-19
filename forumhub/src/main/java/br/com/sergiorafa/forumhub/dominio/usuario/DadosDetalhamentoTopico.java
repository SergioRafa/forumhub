package br.com.sergiorafa.forumhub.dominio.topico;

import br.com.sergiorafa.forumhub.model.StatusTopico;
import br.com.sergiorafa.forumhub.model.Topico; // Importação corrigida
import java.time.LocalDateTime;

/**
 * Record para detalhar os dados de um tópico.
 * Utiliza o construtor para extrair dados específicos da entidade Topico.
 */
public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        String autor,
        String curso,
        StatusTopico status,
        LocalDateTime dataCriacao
) {
    /**
     * Construtor para criar o DTO a partir da entidade Topico.
     * @param topico A entidade Topico da qual os dados serão extraídos.
     */
    public DadosDetalhamentoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getAutor().getLogin(),
                topico.getCurso().getNome(),
                topico.getStatus(),
                topico.getDataCriacao()
        );
    }
}
