package org.serratec.eventos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.eventos.dto.request.RecAcessibilidadeRequestDTO;
import org.serratec.eventos.dto.response.RecAcessibilidadeResponseDTO;
import org.serratec.eventos.service.RecAcessibilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Recursos de Acessibilidade", description = "Endpoints para gerenciamento de recursos de acessibilidade")
@RestController
@RequestMapping("/recurso-acessibilidade")
public class RecAcessibilidadeController {

    @Autowired
    RecAcessibilidadeService recAcessibilidadeService;

    @Operation(
            summary = "Lista todos os recursos de acessibilidade cadastrados",
            description = "Retorna uma lista com todos os recursos de acessibilidade cadastrados, incluindo os eventos em que eles estão vinculados"
    )
    @GetMapping
    public ResponseEntity<List<RecAcessibilidadeResponseDTO>> buscarTodos() {
        List<RecAcessibilidadeResponseDTO> recursos = recAcessibilidadeService.listarTodos();
        return ResponseEntity.ok(recursos);
    }

    @Operation(
            summary = "Lista os recursos de acessibilidade pelo ID",
            description = "Retorna o recurso de acessibilidade correspondente ao ID fornecido, incluindo os eventos em que ele está vinculado. Se o recurso de acessibilidade não for encontrado, retorna 404 Not Found"
    )
    @GetMapping("/{id}")
    public ResponseEntity<RecAcessibilidadeResponseDTO> buscarPorId(@PathVariable Long id) {
        if(recAcessibilidadeService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recAcessibilidadeService.buscarPorId(id));
    }

    @Operation(
            summary = "Realiza o cadastro de um recurso de acessibilidade",
            description = "Recebe os dados de um novo recurso de acessibilidade, realiza a validação e o cadastro. Retorna os dados do recurso de acessibilidade cadastrado com status 201 Created. Se houver erros de validação, retorna 400 Bad Request com detalhes dos erros"
    )
    @PostMapping
    public ResponseEntity<RecAcessibilidadeResponseDTO> cadastrar(@Valid @RequestBody RecAcessibilidadeRequestDTO recursoRequest) {
        RecAcessibilidadeResponseDTO recursoResponse = recAcessibilidadeService.salvar(recursoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(recursoResponse);
    }

    @Operation(
            summary = "Vincula um recurso de acessibilidade á um evento",
            description = "Faz a ligação entre um recurso de acessibilidade e um evento, realiza a validação e retorna um erro 404 Not Found se o recurso ou o evento não forem encontrados"
    )
    @PostMapping("/{idRecurso}/vincular/{idEvento}")
    public ResponseEntity<Void> vincularEvento(@PathVariable Long idRecurso, @PathVariable Long idEvento) {
        recAcessibilidadeService.vincularEvento(idRecurso, idEvento);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Remove um recurso de acessibilidade",
            description = "Remove o recurso de acessibilidade correspondente ao ID fornecido. Se o recurso de acessibilidade não for encontrado, retorna 404 Not Found. Se o recurso de acessibilidade for removido com sucesso, retorna 204 No Content"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (recAcessibilidadeService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        recAcessibilidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
