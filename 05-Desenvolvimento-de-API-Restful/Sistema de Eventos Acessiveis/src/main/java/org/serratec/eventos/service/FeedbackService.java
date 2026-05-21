package org.serratec.eventos.service;

import org.serratec.eventos.domain.Evento;
import org.serratec.eventos.domain.Feedback;
import org.serratec.eventos.domain.Local;
import org.serratec.eventos.domain.Participante;
import org.serratec.eventos.dto.request.EventoRequestDTO;
import org.serratec.eventos.dto.request.FeedbackRequestDTO;
import org.serratec.eventos.dto.response.EventoResponseDTO;
import org.serratec.eventos.dto.response.FeedbackResponseDTO;
import org.serratec.eventos.exception.ResourceNotFoundException;
import org.serratec.eventos.repository.EventoRepository;
import org.serratec.eventos.repository.FeedbackRepository;
import org.serratec.eventos.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private EventoService eventoService;

    @Autowired
    private ParticipanteService participanteService;
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<FeedbackResponseDTO> listarTodos() {
        return feedbackRepository.findAll().stream()
                .map(FeedbackResponseDTO::new)
                .collect(Collectors.toList());
    }

    public FeedbackResponseDTO buscarPorId(Long id) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback não encontrado com id: " + id));
        return new FeedbackResponseDTO(feedback);
    }

    public FeedbackResponseDTO salvar(FeedbackRequestDTO feedbackRequestDTO) {
        Evento evento = eventoRepository.findById(feedbackRequestDTO.getIdEvento())
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado"));

        Participante participante = participanteRepository.findById(feedbackRequestDTO.getIdParticipante())
                .orElseThrow(() -> new ResourceNotFoundException("Participante não encontrado"));

        Feedback feedback = new Feedback();
        feedback.setComentario(feedbackRequestDTO.getComentario());
        feedback.setNota(feedbackRequestDTO.getNota());
        feedback.setEvento(evento);
        feedback.setParticipante(participante);

        feedbackRepository.save(feedback);

        return new FeedbackResponseDTO(feedback);
    }

    public void deletar(Long id) {
        if (!feedbackRepository.existsById(id)) {
            throw new RuntimeException("Não é possível deletar. Feedback não encontrado com id: " + id);
        }
        feedbackRepository.deleteById(id);
    }
}
