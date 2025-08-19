package br.com.sergiorafa.forumhub.repository;


import br.com.sergiorafa.forumhub.dominio.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Repositório para a entidade Usuario.
 * Extende JpaRepository para ter acesso aos métodos de persistência do Spring Data JPA.
 * O método findByLogin é criado para ser usado pelo Spring Security.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}

