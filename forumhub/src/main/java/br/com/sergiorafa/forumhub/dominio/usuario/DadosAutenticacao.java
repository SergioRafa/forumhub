package br.com.sergiorafa.forumhub.dominio;

// Importa a anotação para validação
import jakarta.validation.constraints.NotBlank;

// Record é uma classe de dados concisa no Java 17+
// Ela cria automaticamente construtores, getters, toString, equals e hashCode
public record DadosAutenticacao(
        // A anotação @NotBlank garante que o campo não seja nulo nem vazio.
        @NotBlank
        String login,

        @NotBlank
        String senha
) {}
