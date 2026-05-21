package org.serratec.eventos.controller;

import jakarta.validation.Valid;
import org.serratec.eventos.dto.request.OrganizadorRequestDTO;
import org.serratec.eventos.dto.response.OrganizadorResponseDTO;
import org.serratec.eventos.service.OrganizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizador")
public class OrganizadorController {

    @Autowired
    private OrganizadorService organizadorService;

    @GetMapping
    public ResponseEntity<List<OrganizadorResponseDTO>> buscarTodos() {
        List<OrganizadorResponseDTO> organizadores = organizadorService.listarTodos();
        return ResponseEntity.ok(organizadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizadorResponseDTO> buscarPorId(@PathVariable Long id) {
        if(organizadorService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(organizadorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<OrganizadorResponseDTO> cadastrar(@Valid @RequestBody OrganizadorRequestDTO organizadorRequest) {
        OrganizadorResponseDTO organizadorResponse = organizadorService.salvar(organizadorRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(organizadorResponse);
    }

    @Transactional
    @PostMapping("/{idOrganizador}/vincular/{idEvento}")
    public ResponseEntity<Void> vincularOrganizador(@PathVariable Long idOrganizador, @PathVariable Long idEvento) {
        organizadorService.vincularOrganizador(idOrganizador, idEvento);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<OrganizadorResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody OrganizadorRequestDTO organizadorRequest) {
        if (organizadorService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        organizadorService.atualizar(id, organizadorRequest);

        OrganizadorResponseDTO atualizar = organizadorService.atualizar(id, organizadorRequest);
        return ResponseEntity.ok(atualizar);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (organizadorService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        organizadorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
