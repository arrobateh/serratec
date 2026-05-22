package org.serratec.eventos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.eventos.dto.request.EventoRequestDTO;
import org.serratec.eventos.dto.response.EventoResponseDTO;
import org.serratec.eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Evento", description = "Endpoints para gerenciamento de eventos")
@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Operation(
            summary = "Lista todos os eventos cadastrados",
            description = "Retorna uma lista com todos os eventos cadastrados, incluindo as categorias vinculadas, os participantes, os recursos de acessibilidade, os feedbacks e local"
    )
    @GetMapping
    public ResponseEntity<List<EventoResponseDTO>> buscarTodos() {
        List<EventoResponseDTO> eventos = eventoService.listarTodos();
        return ResponseEntity.ok(eventos);
    }

    @Operation(
            summary = "Lista os eventos pelo ID",
            description = "Retorna o evento correspondente ao ID fornecido, incluindo as categorias vinculadas, os participantes, os recursos de acessibilidade, os feedbacks e o local"
    )
    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> buscarPorId(@PathVariable Long id) {
        if(eventoService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(eventoService.buscarPorId(id));
    }

    @Operation(
            summary = "Realiza o cadastro de um evento",
            description = "Recebe os dados de um novo evento, realiza a validação e o cadastro. Retorna os dados do evento cadastrado com status 201 Created. Se houver erros de validação, retorna 400 Bad Request com detalhes dos erros."
    )
    @PostMapping
    public ResponseEntity<EventoResponseDTO> cadastrar(@Valid @RequestBody EventoRequestDTO eventoRequest) {
        EventoResponseDTO eventoResponse = eventoService.salvar(eventoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoResponse);
    }

    @Operation(
            summary = "Atualiza os dados de um evento",
            description = "Recebe os dados atualizados de um evento existente, realiza a validação e a atualização. Retorna os dados do evento atualizado com status 200 OK. Se o evento não for encontrado, retorna 404 Not Found. Se houver erros de validação, retorna 400 Bad Request com detalhes dos erros."
    )
    @PutMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody EventoRequestDTO eventoRequest) {
        if (eventoService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        eventoService.atualizar(id, eventoRequest);

        EventoResponseDTO atualizar = eventoService.atualizar(id, eventoRequest);
        return ResponseEntity.ok(atualizar);
    }

    @Operation(
            summary = "Remove um evento",
            description = "Remove o evento correspondente ao ID fornecido. Se o evento não for encontrado, retorna 404 Not Found. Se o evento for removido com sucesso, retorna 204 No Content."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (eventoService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        eventoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
