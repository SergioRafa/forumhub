package br.com.sergiorafa.forumhub.dominio.token;


// criação automaticamente construtores, getters, toString, equals e hashCode
public record DadosToken(
        org.springframework.security.core.token.Token token
) {}


