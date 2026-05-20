package org.serratec.eventos.service;

import org.serratec.eventos.domain.Evento;
import org.serratec.eventos.domain.Local;
import org.serratec.eventos.dto.request.EventoRequestDTO;
import org.serratec.eventos.dto.response.EventoResponseDTO;
import org.serratec.eventos.exception.ResourceNotFoundException;
import org.serratec.eventos.repository.EventoRepository;
import org.serratec.eventos.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private LocalRepository localRepository;

    public List<EventoResponseDTO> listarTodos() {
        return eventoRepository.findAll().stream()
                .map(EventoResponseDTO::new)
                .collect(Collectors.toList());
    }

    public EventoResponseDTO buscarPorId(Long id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com id: " + id));
        return new EventoResponseDTO(evento);
    }

    public EventoResponseDTO salvar(EventoRequestDTO eventoRequestDTO) {
        Local local = localRepository.findById(eventoRequestDTO.getIdLocal())
                .orElseThrow(() -> new ResourceNotFoundException("Local não encontrado"));

        Evento evento = new Evento();
        evento.setNome(eventoRequestDTO.getNome());
        evento.setDataEvento(eventoRequestDTO.getDataEvento());
        evento.setLocalEvento(local);

        eventoRepository.save(evento);

        return new EventoResponseDTO(evento);
    }

    public EventoResponseDTO atualizar(Long id, EventoRequestDTO eventoRequestDTO) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com id: " + id));

        evento.setNome(eventoRequestDTO.getNome());
        evento.setDataEvento(eventoRequestDTO.getDataEvento());
        evento.setLocalEvento(localRepository.findById(eventoRequestDTO.getIdLocal())
                .orElseThrow(() -> new ResourceNotFoundException("Local não encontrado com id: " + eventoRequestDTO.getIdLocal())));

        eventoRepository.save(evento);

        return new EventoResponseDTO(evento);
    }

    public void deletar(Long id) {
        if (!eventoRepository.existsById(id)) {
            throw new RuntimeException("Não é possível deletar. Evento não encontrado com id: " + id);
        }
        eventoRepository.deleteById(id);
    }
}
