package br.com.sergiorafa.forumhub.dominio.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroUsuario(
        @NotBlank
        String login,
        @NotBlank
        @Size(min = 6, max = 20)
        String senha
) {}

