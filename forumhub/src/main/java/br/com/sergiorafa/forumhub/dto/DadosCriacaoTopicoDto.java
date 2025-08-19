package br.com.sergiorafa.forumhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO para receber os dados de criação de um novo tópico.
 * Utiliza anotações de validação para garantir que os campos obrigatórios não estejam em branco ou nulos.
 */
public record DadosCriacaoTopicoDto(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        Long idAutor,
        @NotBlank
        String nomeCurso
) {}
