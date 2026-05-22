package org.serratec.eventos.controller;

import jakarta.validation.Valid;
import org.serratec.eventos.domain.CategoriaEvento;
import org.serratec.eventos.dto.request.CategoriaEventoRequestDTO;
import org.serratec.eventos.dto.request.ParticipanteRequestDTO;
import org.serratec.eventos.dto.response.CategoriaEventoResponseDTO;
import org.serratec.eventos.dto.response.ParticipanteResponseDTO;
import org.serratec.eventos.service.CategoriaEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaEventoController {

    @Autowired
    private CategoriaEventoService categoriaEventoService;

    @GetMapping
    public ResponseEntity<List<CategoriaEventoResponseDTO>> buscarTodos() {
        List<CategoriaEventoResponseDTO> categoriaEvento = categoriaEventoService.listarTodos();
        return ResponseEntity.ok(categoriaEvento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaEventoResponseDTO> buscarPorId(@PathVariable Long id) {
        if(categoriaEventoService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoriaEventoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaEventoResponseDTO> cadastrar(@Valid @RequestBody CategoriaEventoRequestDTO categoriaEventoRequest) {
        CategoriaEventoResponseDTO categoriaEventoResponse = categoriaEventoService.salvar(categoriaEventoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaEventoResponse);
    }

    @PostMapping("/{idCategoriaEvento}/vincular/{idEvento}")
    public ResponseEntity<Void> vincularCategoriaEvento(@PathVariable Long idCategoriaEvento, @PathVariable Long idEvento) {
        categoriaEventoService.vincularCategoria(idCategoriaEvento, idEvento);
        return ResponseEntity.ok().build();
    }

}
