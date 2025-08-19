package br.com.sergiorafa.forumhub.configuration.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaTeste {
    public static void main(String[] args) {
        String senha = "122125";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaCriptografada = encoder.encode(senha);
        System.out.println("Senha criptografada: " + senhaCriptografada);
    }
}

