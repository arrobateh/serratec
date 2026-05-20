package org.serratec.eventos.service;

import org.serratec.eventos.domain.Evento;
import org.serratec.eventos.domain.Local;
import org.serratec.eventos.domain.Participante;
import org.serratec.eventos.dto.request.EventoRequestDTO;
import org.serratec.eventos.dto.request.ParticipanteRequestDTO;
import org.serratec.eventos.dto.response.EventoResponseDTO;
import org.serratec.eventos.dto.response.ParticipanteResponseDTO;
import org.serratec.eventos.exception.ResourceNotFoundException;
import org.serratec.eventos.repository.LocalRepository;
import org.serratec.eventos.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ParticipanteService {
    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<ParticipanteResponseDTO> listarTodos() {
        return participanteRepository.findAll().stream()
                .map(ParticipanteResponseDTO::new)
                .collect(Collectors.toList());
    }

    public ParticipanteResponseDTO buscarPorId(Long id) {
        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Participante não encontrado com id: " + id));
        return new ParticipanteResponseDTO(participante);
    }

    public ParticipanteResponseDTO salvar(ParticipanteRequestDTO participanteRequestDTO) {

        Participante participante = new Participante();
        participante.setNomeParticipante(participanteRequestDTO.getNomeParticipante());
        participante.setDataNascimento(participanteRequestDTO.getDataNascimento());
        participante.setEmail(participanteRequestDTO.getEmail());

        participanteRepository.save(participante);

        return new ParticipanteResponseDTO(participante);
    }

    public ParticipanteResponseDTO atualizar(Long id, ParticipanteRequestDTO participanteRequestDTO) {
        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Participante não encontrado com id: " + id));

        participante.setNomeParticipante(participanteRequestDTO.getNomeParticipante());
        participante.setDataNascimento(participanteRequestDTO.getDataNascimento());
        participante.setEmail(participanteRequestDTO.getEmail());

        participanteRepository.save(participante);

        return new ParticipanteResponseDTO(participante);
    }

    public void deletar(Long id) {
        if (!participanteRepository.existsById(id)) {
            throw new RuntimeException("Não é possível deletar. Participante não encontrado com id: " + id);
        }
        participanteRepository.deleteById(id);
    }
}
