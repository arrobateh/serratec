package org.serratec.eventos.service;

import org.serratec.eventos.domain.Evento;
import org.serratec.eventos.domain.Local;
import org.serratec.eventos.domain.RecursoAcessibilidade;
import org.serratec.eventos.dto.request.EventoRequestDTO;
import org.serratec.eventos.dto.request.RecAcessibilidadeRequestDTO;
import org.serratec.eventos.dto.response.EventoResponseDTO;
import org.serratec.eventos.dto.response.RecAcessibilidadeResponseDTO;
import org.serratec.eventos.exception.ResourceNotFoundException;
import org.serratec.eventos.repository.EventoRepository;
import org.serratec.eventos.repository.RecAcessibilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecAcessibilidadeService {
    @Autowired
    private RecAcessibilidadeRepository recAcessibilidadeRepository;

    @Autowired
    private EventoService eventoService;
    @Autowired
    private EventoRepository eventoRepository;

    public List<RecAcessibilidadeResponseDTO> listarTodos() {
        return recAcessibilidadeRepository.findAll().stream()
                .map(RecAcessibilidadeResponseDTO::new)
                .collect(Collectors.toList());
    }

    public RecAcessibilidadeResponseDTO buscarPorId(Long id) {
        RecursoAcessibilidade recurso = recAcessibilidadeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso de acessibilidade não encontrado com id: " + id));
        return new RecAcessibilidadeResponseDTO(recurso);
    }

    public RecAcessibilidadeResponseDTO salvar(RecAcessibilidadeRequestDTO recursoRequestDTO) {
        RecursoAcessibilidade recurso = new RecursoAcessibilidade();
        recurso.setNomeRecursoAcessibilidade(recursoRequestDTO.getNomeRecursoAcessibilidade());

        recAcessibilidadeRepository.save(recurso);

        return new RecAcessibilidadeResponseDTO(recurso);
    }

    @Transactional
    public void vincularEvento(Long idRecurso, Long idEvento) {
        RecursoAcessibilidade recurso = recAcessibilidadeRepository.findById(idRecurso)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso de acessibilidade não encontrado com id: " + idRecurso));
        Evento evento = eventoRepository.findById(idEvento)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com o ID: " + idEvento));

        recurso.getEventos().add(evento);
        recAcessibilidadeRepository.save(recurso);

        evento.getRecursoAcessibilidade().add(recurso);
        eventoRepository.save(evento);
    }

    public void deletar (Long id) {
        if (!recAcessibilidadeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Não é possível deletar. Recurso de acessibilidade não encontrado com id: " + id);
        }
        recAcessibilidadeRepository.deleteById(id);
    }
}
