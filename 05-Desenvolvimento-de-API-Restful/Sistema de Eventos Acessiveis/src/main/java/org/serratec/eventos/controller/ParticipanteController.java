package org.serratec.eventos.controller;

import jakarta.validation.Valid;
import org.serratec.eventos.dto.request.EventoRequestDTO;
import org.serratec.eventos.dto.request.ParticipanteRequestDTO;
import org.serratec.eventos.dto.response.EventoResponseDTO;
import org.serratec.eventos.dto.response.ParticipanteResponseDTO;
import org.serratec.eventos.repository.ParticipanteRepository;
import org.serratec.eventos.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participante")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public ResponseEntity<List<ParticipanteResponseDTO>> buscarTodos() {
        List<ParticipanteResponseDTO> participante = participanteService.listarTodos();
        return ResponseEntity.ok(participante);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipanteResponseDTO> buscarPorId(@PathVariable Long id) {
        if(participanteService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(participanteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ParticipanteResponseDTO> cadastrar(@Valid @RequestBody ParticipanteRequestDTO participanteRequest) {
        ParticipanteResponseDTO participanteResponse = participanteService.salvar(participanteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(participanteResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipanteResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ParticipanteRequestDTO participanteRequest) {
        if (participanteService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        participanteService.atualizar(id, participanteRequest);

        ParticipanteResponseDTO atualizar = participanteService.atualizar(id, participanteRequest);
        return ResponseEntity.ok(atualizar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (participanteService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        participanteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
