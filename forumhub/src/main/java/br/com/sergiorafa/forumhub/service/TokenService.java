package br.com.sergiorafa.forumhub.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import br.com.sergiorafa.forumhub.dominio.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service // Anotação para que o Spring gerencie essa classe como um bean
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret; // A chave secreta para assinar o token, vinda do application.properties

    public String gerarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API ForumHub") // Define o emissor do token
                    .withSubject(usuario.getLogin()) // Define o assunto (subject) do token, que é o login do usuário
                    .withExpiresAt(dataExpiracao()) // Define a data de expiração do token
                    .sign(algoritmo); // Assina o token com o algoritmo e a chave secreta
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerar token jwt", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API ForumHub") // Requer que o emissor seja o mesmo
                    .build()
                    .verify(tokenJWT) // Verifica se o token é válido
                    .getSubject(); // Retorna o assunto (subject) do token
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    // Método que define a data de expiração do token (em 2 horas)
    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
