package br.com.sergiorafa.forumhub.service;

import br.com.sergiorafa.forumhub.dominio.erro.ValidacaoException;
import br.com.sergiorafa.forumhub.dominio.topico.DadosCadastroTopico;
import br.com.sergiorafa.forumhub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public void validarTopico(DadosCadastroTopico dados) {
        var tituloDuplicado = topicoRepository.existsByTitulo(dados.titulo());
        if (tituloDuplicado) {
            throw new ValidacaoException("Título já cadastrado.");
        }

        var mensagemDuplicada = topicoRepository.existsByMensagem(dados.mensagem());
        if (mensagemDuplicada) {
            throw new ValidacaoException("Mensagem já cadastrada.");
        }
    }

    public void validarCadastro(@Valid DadosCadastroTopico dados) {
    }
}

