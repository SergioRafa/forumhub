package br.com.sergiorafa.forumhub.repository;

import br.com.sergiorafa.forumhub.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para a entidade Curso.
 * O método findByNome é criado para que o Controller possa buscar um Curso pelo nome.
 */
public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNome(String nome);
}
