package org.serratec.eventos.controller;

import jakarta.validation.Valid;
import org.serratec.eventos.dto.request.LocalRequestDTO;
import org.serratec.eventos.dto.response.LocalResponseDTO;
import org.serratec.eventos.repository.LocalRepository;
import org.serratec.eventos.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/local")
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping
    public ResponseEntity<List<LocalResponseDTO>> listar() {
        List<LocalResponseDTO> locais = localService.listarTodos();
        return ResponseEntity.ok(locais);
    }

    // Buscar local por ID
    @GetMapping("/{id}")
    public ResponseEntity<LocalResponseDTO> buscarPorId(@PathVariable Long id) {
        if(localService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(localService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<LocalResponseDTO> cadastrar(@Valid @RequestBody LocalRequestDTO localRequest) {
        LocalResponseDTO localResponse = localService.salvar(localRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(localResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody LocalRequestDTO localRequest) {
        if (localService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }

        LocalResponseDTO atualizar = localService.atualizar(id, localRequest);
        return ResponseEntity.ok(atualizar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (localService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        localService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
