package org.serratec.eventos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Local do Evento", description = "Endpoints para gerenciamento dos locais dos eventos")
@RestController
@RequestMapping("/local")
public class LocalController {

    @Autowired
    private LocalService localService;

    @Operation(
            summary = "Lista todos os locais cadastrados",
            description = "Retorna uma lista com todos os locais cadastrados, incluindo os eventos em que ele está vinculado. Se o local não for encontrado, retorna 404 Not Found"
    )
    @GetMapping
    public ResponseEntity<List<LocalResponseDTO>> listar() {
        List<LocalResponseDTO> locais = localService.listarTodos();
        return ResponseEntity.ok(locais);
    }

    @Operation(
            summary = "Lista os locais pelo ID",
            description = "Retorna o local correspondente ao ID fornecido, incluindo os eventos em que ele está vinculado. Se o local não for encontrado, retorna 404 Not Found"
    )
    @GetMapping("/{id}")
    public ResponseEntity<LocalResponseDTO> buscarPorId(@PathVariable Long id) {
        if(localService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(localService.buscarPorId(id));
    }

    @Operation(
            summary = "Realiza o cadastro de um local",
            description = "Recebe os dados de um novo local, realiza a validação e o cadastro. Retorna os dados do local cadastrado com status 201 Created. Se houver erros de validação, retorna 400 Bad Request com detalhes dos erros"
    )
    @PostMapping
    public ResponseEntity<LocalResponseDTO> cadastrar(@Valid @RequestBody LocalRequestDTO localRequest) {
        LocalResponseDTO localResponse = localService.salvar(localRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(localResponse);
    }

    @Operation(
            summary = "Atualiza os dados de um local",
            description = "Recebe os dados atualizados de um local existente, realiza a validação e a atualização. Retorna os dados do local atualizado com status 200 OK. Se o local não for encontrado, retorna 404 Not Found. Se houver erros de validação, retorna 400 Bad Request com detalhes dos erros"
    )
    @PutMapping("/{id}")
    public ResponseEntity<LocalResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody LocalRequestDTO localRequest) {
        if (localService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }

        LocalResponseDTO atualizar = localService.atualizar(id, localRequest);
        return ResponseEntity.ok(atualizar);
    }

    @Operation(
            summary = "Remove um local",
            description = "Remove o local correspondente ao ID fornecido. Se o local não for encontrado, retorna 404 Not Found. Se o local for removido com sucesso, retorna 204 No Content"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (localService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        localService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
