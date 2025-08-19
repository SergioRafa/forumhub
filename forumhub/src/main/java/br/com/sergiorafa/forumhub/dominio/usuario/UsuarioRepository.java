package br.com.sergiorafa.forumhub.dominio.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

// A interface JpaRepository recebe a entidade (Usuario) e o tipo do ID (Long)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // O Spring Data JPA cria a query automaticamente com base no nome do método.
    // Ele irá buscar um usuário pelo campo 'login'.
    Usuario findByLogin(String login);
}

