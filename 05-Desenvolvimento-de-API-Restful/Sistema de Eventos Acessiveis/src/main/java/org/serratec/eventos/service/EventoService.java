package org.serratec.eventos.service;

import org.serratec.eventos.domain.Evento;
import org.serratec.eventos.domain.Local;
import org.serratec.eventos.dto.request.EventoResquestDTO;
import org.serratec.eventos.dto.response.EventoResponseDTO;
import org.serratec.eventos.repository.EventoRepository;
import org.serratec.eventos.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private LocalRepository localRepository;

    public EventoResponseDTO salvar(EventoResquestDTO eventoResquestDTO) {
        Local local = localRepository.findById(eventoResquestDTO.getIdLocal())
                .orElseThrow(() -> new RuntimeException("Local não encontrado"));

        Evento evento = new Evento();
        evento.setNome(eventoResquestDTO.getNome());
        evento.setDataEvento(eventoResquestDTO.getDataEvento());
        evento.setLocalEvento(local);

        evento = eventoRepository.save(evento);

        return new EventoResponseDTO(evento);
    }
}
