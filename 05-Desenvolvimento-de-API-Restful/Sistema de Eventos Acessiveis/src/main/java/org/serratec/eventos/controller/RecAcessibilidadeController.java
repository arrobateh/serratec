package org.serratec.eventos.controller;

import jakarta.validation.Valid;
import org.serratec.eventos.dto.request.RecAcessibilidadeRequestDTO;
import org.serratec.eventos.dto.response.RecAcessibilidadeResponseDTO;
import org.serratec.eventos.service.RecAcessibilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recurso-acessibilidade")
public class RecAcessibilidadeController {

    @Autowired
    RecAcessibilidadeService recAcessibilidadeService;

    @GetMapping
    public ResponseEntity<List<RecAcessibilidadeResponseDTO>> buscarTodos() {
        List<RecAcessibilidadeResponseDTO> recursos = recAcessibilidadeService.listarTodos();
        return ResponseEntity.ok(recursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecAcessibilidadeResponseDTO> buscarPorId(@PathVariable Long id) {
        if(recAcessibilidadeService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recAcessibilidadeService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RecAcessibilidadeResponseDTO> cadastrar(@Valid @RequestBody RecAcessibilidadeRequestDTO recursoRequest) {
        RecAcessibilidadeResponseDTO recursoResponse = recAcessibilidadeService.salvar(recursoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(recursoResponse);
    }

    @PostMapping("/{idRecurso}/vincular/{idEvento}")
    public ResponseEntity<Void> vincularEvento(@PathVariable Long idRecurso, @PathVariable Long idEvento) {
        recAcessibilidadeService.vincularEvento(idRecurso, idEvento);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (recAcessibilidadeService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        recAcessibilidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
