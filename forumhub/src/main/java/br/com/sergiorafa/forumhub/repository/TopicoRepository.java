package br.com.sergiorafa.forumhub.repository;

import br.com.sergiorafa.forumhub.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para a entidade Topico.
 * Extende JpaRepository para ter acesso aos métodos de persistência do Spring Data JPA.
 */
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Método para buscar tópicos ativos e paginados.
    Page<Topico> findAllByStatusTrue(Pageable paginacao);

    // Método para verificar se um tópico com um título específico já existe.
    boolean existsByTitulo(String titulo);

    // Método para verificar se um tópico com uma mensagem específica já existe.
    boolean existsByMensagem(String mensagem);

    // Novo método para verificar se o título já existe, ignorando um ID específico.
    boolean existsByTituloAndIdNot(String titulo, Long id);

    // Novo método para verificar se a mensagem já existe, ignorando um ID específico.
    boolean existsByMensagemAndIdNot(String mensagem, Long id);
}
