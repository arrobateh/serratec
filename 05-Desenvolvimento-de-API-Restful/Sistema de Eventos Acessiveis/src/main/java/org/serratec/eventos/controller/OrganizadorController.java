package org.serratec.eventos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Organizador do Evento", description = "Endpoints para gerenciamento de organizadores")
@RestController
@RequestMapping("/organizador")
public class OrganizadorController {

    @Autowired
    private OrganizadorService organizadorService;

    @Operation(
            summary = "Lista todos os organizadores cadastrados",
            description = "Retorna uma lista com todos os organizadores cadastrados, incluindo os eventos em que ele está vinculado"
    )
    @GetMapping
    public ResponseEntity<List<OrganizadorResponseDTO>> buscarTodos() {
        List<OrganizadorResponseDTO> organizadores = organizadorService.listarTodos();
        return ResponseEntity.ok(organizadores);
    }

    @Operation(
            summary = "Lista os organizadores pelo ID",
            description = "Retorna o organizador correspondente ao ID fornecido, incluindo os eventos em que ele está vinculado. Se o organizador não for encontrado, retorna 404 Not Found"
    )
    @GetMapping("/{id}")
    public ResponseEntity<OrganizadorResponseDTO> buscarPorId(@PathVariable Long id) {
        if(organizadorService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(organizadorService.buscarPorId(id));
    }

    @Operation(
            summary = "Realiza o cadastro de um organizador",
            description = "Recebe os dados de um novo organizador, realiza a validação e o cadastro. Retorna os dados do organizador cadastrado com status 201 Created. Se houver erros de validação, retorna 400 Bad Request com detalhes dos erros"
    )
    @PostMapping
    public ResponseEntity<OrganizadorResponseDTO> cadastrar(@Valid @RequestBody OrganizadorRequestDTO organizadorRequest) {
        OrganizadorResponseDTO organizadorResponse = organizadorService.salvar(organizadorRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(organizadorResponse);
    }

    @Operation(
            summary = "Vincula um organizador á um evento",
            description = "Faz a ligação entre um organizador e um evento, realiza a validação e retorna um erro 404 Not Found se o organizador ou o evento não forem encontrados"
    )
    @Transactional
    @PostMapping("/{idOrganizador}/vincular/{idEvento}")
    public ResponseEntity<Void> vincularOrganizador(@PathVariable Long idOrganizador, @PathVariable Long idEvento) {
        organizadorService.vincularOrganizador(idOrganizador, idEvento);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Atualiza os dados de um organizador",
            description = "Recebe os dados atualizados de um organizador existente, realiza a validação e a atualização. Retorna os dados do organizador atualizado com status 200 OK. Se o organizador não for encontrado, retorna 404 Not Found. Se houver erros de validação, retorna 400 Bad Request com detalhes dos erros"
    )
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

    @Operation(
            summary = "Remove um organizador",
            description = "Remove o organizador correspondente ao ID fornecido. Se o organizador não for encontrado, retorna 404 Not Found. Se o organizador for removido com sucesso, retorna 204 No Content"
    )
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
