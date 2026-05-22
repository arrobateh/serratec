package org.serratec.eventos.service;

import org.serratec.eventos.domain.CategoriaEvento;
import org.serratec.eventos.domain.Evento;
import org.serratec.eventos.domain.Organizador;
import org.serratec.eventos.domain.Participante;
import org.serratec.eventos.dto.request.CategoriaEventoRequestDTO;
import org.serratec.eventos.dto.request.ParticipanteRequestDTO;
import org.serratec.eventos.dto.response.CategoriaEventoResponseDTO;
import org.serratec.eventos.dto.response.EventoResponseDTO;
import org.serratec.eventos.dto.response.ParticipanteResponseDTO;
import org.serratec.eventos.exception.ResourceNotFoundException;
import org.serratec.eventos.repository.CategoriaEventoRepository;
import org.serratec.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaEventoService {

    @Autowired
    private CategoriaEventoRepository categoriaEventoRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Transactional(readOnly = true)
    public List<CategoriaEventoResponseDTO> listarTodos() {
        return categoriaEventoRepository.findAll().stream()
                .map(CategoriaEventoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoriaEventoResponseDTO buscarPorId(Long id) {
        CategoriaEvento categoriaEvento = categoriaEventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com id: " + id));
        return new CategoriaEventoResponseDTO(categoriaEvento);
    }

    public CategoriaEventoResponseDTO salvar(CategoriaEventoRequestDTO categoriaEventoRequestDTO) {

        CategoriaEvento categoriaEvento = new CategoriaEvento();
        categoriaEvento.setNomeCategoriaEvento(categoriaEventoRequestDTO.getNomeCategoriaEvento());

        categoriaEventoRepository.save(categoriaEvento);

        return new CategoriaEventoResponseDTO(categoriaEvento);
    }

    @Transactional
    public void vincularCategoria (Long idCategoriaEvento, Long idEvento) {
        CategoriaEvento categoriaEvento = categoriaEventoRepository.findById(idCategoriaEvento)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com id: " + idCategoriaEvento));
        Evento evento = eventoRepository.findById(idEvento)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com o ID: " + idEvento));

        categoriaEvento.getEventos().add(evento);
        categoriaEventoRepository.save(categoriaEvento);

        evento.setCategoriaEvento(categoriaEvento);
        eventoRepository.save(evento);
    }

    public void deletar(Long id) {
        CategoriaEvento categoriaEvento = categoriaEventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com id: " + id));

        categoriaEvento.getEventos()
                .forEach(evento -> evento.setCategoriaEvento(null));
        categoriaEventoRepository.delete(categoriaEvento);
    }
}
