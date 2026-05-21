package org.serratec.eventos.controller;

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

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public ResponseEntity<List<FeedbackResponseDTO>> buscarTodos() {
        List<FeedbackResponseDTO> feedbacks = feedbackService.listarTodos();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackResponseDTO> buscarPorId(@PathVariable Long id) {
        if (feedbackService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(feedbackService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<FeedbackResponseDTO> cadastrar(@Valid @RequestBody FeedbackRequestDTO feedbackRequest) {
        FeedbackResponseDTO feedbackResponse = feedbackService.salvar(feedbackRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackResponse);
    }

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
