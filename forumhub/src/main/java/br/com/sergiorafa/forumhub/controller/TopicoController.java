package br.com.sergiorafa.forumhub.controller;

import br.com.sergiorafa.forumhub.dominio.usuario.Usuario;
import br.com.sergiorafa.forumhub.dto.DadosCriacaoTopicoDto;
import br.com.sergiorafa.forumhub.dto.DadosListagemTopicoDto;
import br.com.sergiorafa.forumhub.model.Curso;
import br.com.sergiorafa.forumhub.model.Topico;
import br.com.sergiorafa.forumhub.repository.CursoRepository;
import br.com.sergiorafa.forumhub.repository.TopicoRepository;
import br.com.sergiorafa.forumhub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    /**
     * Endpoint para criar um novo tópico.
     * @param dados Dados do tópico a ser criado, validados automaticamente pelo @Valid.
     * @return Resposta HTTP 200 OK.
     */
    @PostMapping
    public ResponseEntity<Void> criarTopico(@RequestBody @Valid DadosCriacaoTopicoDto dados) {
        Usuario autor = usuarioRepository.getReferenceById(dados.idAutor());
        Curso curso = cursoRepository.findByNome(dados.nomeCurso());

        if (autor == null || curso == null) {
            return ResponseEntity.badRequest().build();
        }

        Topico topico = new Topico(dados.titulo(), dados.mensagem(), autor, curso);
        topicoRepository.save(topico);

        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint para listar todos os tópicos, com paginação.
     * @param paginacao Parâmetros de paginação fornecidos pela requisição.
     * @return Uma página de tópicos em forma de DTO.
     */
    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicoDto>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        // Busca tópicos ativos e os mapeia para o DTO de listagem usando uma referência de método.
        Page<DadosListagemTopicoDto> page = topicoRepository.findAllByStatusTrue(paginacao).map(DadosListagemTopicoDto::new);
        return ResponseEntity.ok(page);
    }
}
