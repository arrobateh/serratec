package org.serratec.eventos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Participante do Evento", description = "Endpoints para gerenciamento de participantes")
@RestController
@RequestMapping("/participante")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @Operation(
            summary = "Lista todos os participantes cadastrados",
            description = "Retorna uma lista com todos os participantes cadastrados, incluindo os eventos em que eles estão inscritos"
    )
    @GetMapping
    public ResponseEntity<List<ParticipanteResponseDTO>> buscarTodos() {
        List<ParticipanteResponseDTO> participante = participanteService.listarTodos();
        return ResponseEntity.ok(participante);
    }

    @Operation(
            summary = "Lista os participantes pelo ID",
            description = "Retorna o participante correspondente ao ID fornecido, incluindo os eventos em que ele está inscrito. Se o participante não for encontrado, retorna 404 Not Found"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ParticipanteResponseDTO> buscarPorId(@PathVariable Long id) {
        if(participanteService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(participanteService.buscarPorId(id));
    }

    @Operation(
            summary = "Realiza o cadastro de um participante",
            description = "Recebe os dados de um novo participante, realiza a validação e o cadastro. Retorna os dados do participante cadastrado com status 201 Created. Se houver erros de validação, retorna 400 Bad Request com detalhes dos erros"
    )
    @PostMapping
    public ResponseEntity<ParticipanteResponseDTO> cadastrar(@Valid @RequestBody ParticipanteRequestDTO participanteRequest) {
        ParticipanteResponseDTO participanteResponse = participanteService.salvar(participanteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(participanteResponse);
    }

    @Operation(
            summary = "Atualiza os dados de um participante",
            description = "Recebe os dados atualizados de um participante existente, realiza a validação e a atualização. Retorna os dados do participante atualizado com status 200 OK. Se o participante não for encontrado, retorna  404 Not Found. Se houver erros de validação, retorna 400 Bad Request com detalhes dos erros"
    )
    @PutMapping("/{id}")
    public ResponseEntity<ParticipanteResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ParticipanteRequestDTO participanteRequest) {
        if (participanteService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        participanteService.atualizar(id, participanteRequest);

        ParticipanteResponseDTO atualizar = participanteService.atualizar(id, participanteRequest);
        return ResponseEntity.ok(atualizar);
    }

    @Operation(
            summary = "Remove um participante",
            description = "Remove um participante existente com base no ID fornecido. Retorna status 204 No Content se a remoção for bem-sucedida. Se o participante não for encontrado, retorna 404 Not Found"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (participanteService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        participanteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Inscrever um participante em um evento",
            description = "Inscreve um participante em um evento. Retorna status 200 OK se a inscrição for bem-sucedida. Se o participante ou o evento não forem encontrados, retorna 404 Not Found"
    )
    @PostMapping("/{idParticipante}/inscrever/{idEvento}")
    public ResponseEntity<Void> inscreverParticipanteEmEvento(@PathVariable Long idParticipante, @PathVariable Long idEvento) {
        participanteService.inscreverParticipanteEmEvento(idParticipante, idEvento);
        return ResponseEntity.ok().build();
    }


}
