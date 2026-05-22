package org.serratec.eventos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.serratec.eventos.dto.request.EventoRequestDTO;
import org.serratec.eventos.dto.request.FeedbackRequestDTO;
import org.serratec.eventos.dto.response.EventoResponseDTO;
import org.serratec.eventos.dto.response.FeedbackResponseDTO;
import org.serratec.eventos.service.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Feedback", description = "Endpoints para gerenciamento de feedbacks")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @Operation(
            summary = "Lista todos os feedbacks cadastrados",
            description = "Retorna uma lista com todos os feedbacks, incluindo o nome do participante que fez o comentario."
    )
    @GetMapping
    public ResponseEntity<List<FeedbackResponseDTO>> buscarTodos() {
        List<FeedbackResponseDTO> feedbacks = feedbackService.listarTodos();
        return ResponseEntity.ok(feedbacks);
    }

    @Operation(
            summary = "Lista os feedbacks pelo ID",
            description = "Retorna o feedback correspondente ao ID fornecido, incluindo o nome do participante que fez o comentario."
    )
    @GetMapping("/{id}")
    public ResponseEntity<FeedbackResponseDTO> buscarPorId(@PathVariable Long id) {
        if (feedbackService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(feedbackService.buscarPorId(id));
    }

    @Operation(
            summary = "Realiza o cadastro de um feedback",
            description = "Permite cadastrar um novo feedback, associando-o a um participante e a um evento. O feedback deve conter uma avaliação (nota) e um comentário. O endpoint valida os dados de entrada e retorna o feedback cadastrado com seu ID gerado."
    )
    @PostMapping
    public ResponseEntity<FeedbackResponseDTO> cadastrar(@Valid @RequestBody FeedbackRequestDTO feedbackRequest) {
        FeedbackResponseDTO feedbackResponse = feedbackService.salvar(feedbackRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackResponse);
    }

    @Operation(
            summary = "Deleta um feedback",
            description = "Permite deletar um feedback existente pelo seu ID. O endpoint verifica se o feedback existe antes de tentar deletá-lo e retorna uma resposta adequada caso o feedback não seja encontrado."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        if (feedbackService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        feedbackService.deletar(id);
//        Opção 1
//        Obs: alterar o tipo do mét0do para retornar ResponseEntity<Void>
//        return ResponseEntity.noContent().build();
        return ResponseEntity.ok("Feedback deletado com sucesso!");
    }
}
