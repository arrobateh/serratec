package com.games.exerciciogames.controller;

import com.games.exerciciogames.model.Jogo;
import com.games.exerciciogames.model.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class JogoController {

    @Autowired
    private JogoRepository jogoRepository;

    // 1. Listar todos
    @GetMapping
    public ResponseEntity<List<Jogo>> listarJogos() {
        return ResponseEntity.ok(jogoRepository.findAll());
    }

    // 2. Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscarPorID(@PathVariable Integer id) {
        Optional<Jogo> jogo = jogoRepository.findById(id);

        if (jogo.isPresent()) {
            return ResponseEntity.ok(jogo.get());
        }
        return ResponseEntity.notFound().build();
    }

    // 3. Cadastrar jogo
    @PostMapping
    public ResponseEntity<Jogo> inserirJogo(@RequestBody Jogo jogo) {
        Jogo jogoSalvo = jogoRepository.save(jogo);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogoSalvo);
    }

    // 4. Atualizar jogo
    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizarJogo(@PathVariable Integer id, @RequestBody Jogo jogo) {
        if (!jogoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jogo.setId(id);
        return ResponseEntity.ok(jogoRepository.save(jogo));
    }

    // 5. Deletar jogo
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (!jogoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jogoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
