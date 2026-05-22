package org.serratec.eventos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Categoria do Evento", description = "Endpoints para gerenciamento das categorias dos eventos")
@RestController
@RequestMapping("/categoria")
public class CategoriaEventoController {

    @Autowired
    private CategoriaEventoService categoriaEventoService;

    @Operation(
            summary = "Lista todas as categorias cadastradas",
            description = "Retorna uma lista com todas as categorias cadastradas, incluindo os eventos em que ela está vinculada."
    )
    @GetMapping
    public ResponseEntity<List<CategoriaEventoResponseDTO>> buscarTodos() {
        List<CategoriaEventoResponseDTO> categoriaEvento = categoriaEventoService.listarTodos();
        return ResponseEntity.ok(categoriaEvento);
    }

    @Operation(
            summary = "Lista as cetegorias pelo ID",
            description = "Retorna a categoria do evento correspondente ao ID fornecido, incluindo os eventos em que ela está vinculada. Se a categoria não for encontrada, retorna 404 Not Found."
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaEventoResponseDTO> buscarPorId(@PathVariable Long id) {
        if(categoriaEventoService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoriaEventoService.buscarPorId(id));
    }

    @Operation(
            summary = "Realiza o cadastro de uma categoria",
            description = "Recebe os dados de uma nova categoria do evento, realiza a validação e o cadastro. Retorna os dados da categoria cadastrada com status 201 Created. Se houver erros de validação, retorna 400 Bad Request com detalhes dos erros."
    )
    @PostMapping
    public ResponseEntity<CategoriaEventoResponseDTO> cadastrar(@Valid @RequestBody CategoriaEventoRequestDTO categoriaEventoRequest) {
        CategoriaEventoResponseDTO categoriaEventoResponse = categoriaEventoService.salvar(categoriaEventoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaEventoResponse);
    }

    @Operation(
            summary = "Vincula uma categoria á um evento",
            description = "Faz a ligação entre uma categoria e um evento, realiza a validação e retorna um erro 404 Not Found se a categoria ou o evento não forem encontrados."
    )
    @PostMapping("/{idCategoriaEvento}/vincular/{idEvento}")
    public ResponseEntity<Void> vincularCategoriaEvento(@PathVariable Long idCategoriaEvento, @PathVariable Long idEvento) {
        categoriaEventoService.vincularCategoria(idCategoriaEvento, idEvento);
        return ResponseEntity.ok().build();
    }

}
