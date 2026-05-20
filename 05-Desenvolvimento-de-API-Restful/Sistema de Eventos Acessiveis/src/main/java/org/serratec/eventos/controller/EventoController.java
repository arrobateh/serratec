package org.serratec.eventos.controller;

import jakarta.validation.Valid;
import org.serratec.eventos.dto.request.EventoRequestDTO;
import org.serratec.eventos.dto.response.EventoResponseDTO;
import org.serratec.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<EventoResponseDTO>> buscarTodos() {
        List<EventoResponseDTO> eventos = eventoService.listarTodos();
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> buscarPorId(@PathVariable Long id) {
        if(eventoService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(eventoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<EventoResponseDTO> cadastrar(@Valid @RequestBody EventoRequestDTO eventoRequest) {
        EventoResponseDTO eventoResponse = eventoService.salvar(eventoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody EventoRequestDTO eventoRequest) {
        if (eventoService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        eventoService.atualizar(id, eventoRequest);

        EventoResponseDTO atualizar = eventoService.atualizar(id, eventoRequest);
        return ResponseEntity.ok(atualizar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (eventoService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        eventoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
