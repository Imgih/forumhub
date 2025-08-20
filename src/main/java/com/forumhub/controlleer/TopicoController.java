package com.forumhub.controlleer;

import com.forumhub.model.Topico;
import com.forumhub.repositorio.TopicoRepositorio;
import com.forumhub.repositorio.TopicoRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepositorio topicoRepository;

    public TopicoController(TopicoRepositorio topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @PostMapping
    public ResponseEntity<Topico> criarTopico(@RequestBody @Valid Topico topico) {
        Topico novoTopico = topicoRepository.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTopico);
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        List<Topico> topicos = topicoRepository.findAll();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> detalharTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        return topico.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> atualizarTopico(@PathVariable Long id, @RequestBody @Valid Topico topico) {
        Optional<Topico> topicoExistente = topicoRepository.findById(id);
        if (topicoExistente.isPresent()) {
            Topico atualizado = topicoExistente.get();
            atualizado.setTitulo(topico.getTitulo());
            atualizado.setMensagem(topico.getMensagem());
            topicoRepository.save(atualizado);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTopico(@PathVariable Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
