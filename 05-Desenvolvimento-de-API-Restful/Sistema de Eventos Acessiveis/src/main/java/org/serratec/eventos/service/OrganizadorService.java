package org.serratec.eventos.service;

import org.serratec.eventos.domain.Evento;
import org.serratec.eventos.domain.Organizador;
import org.serratec.eventos.dto.request.OrganizadorRequestDTO;
import org.serratec.eventos.dto.response.OrganizadorResponseDTO;
import org.serratec.eventos.exception.ResourceNotFoundException;
import org.serratec.eventos.repository.EventoRepository;
import org.serratec.eventos.repository.OrganizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizadorService {

    @Autowired
    OrganizadorRepository organizadorRepository;

    @Autowired
    EventoService eventoService;
    @Autowired
    private EventoRepository eventoRepository;

    public List<OrganizadorResponseDTO> listarTodos() {
        return organizadorRepository.findAll().stream()
                .map(OrganizadorResponseDTO::new)
                .collect(Collectors.toList());
    }

    public OrganizadorResponseDTO buscarPorId(Long id) {
        Organizador organizador = organizadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organizador não encontrado com o ID: " + id));
        return new OrganizadorResponseDTO(organizador);
    }

    public OrganizadorResponseDTO salvar(OrganizadorRequestDTO organizadorRequestDTO) {
        Organizador organizador = new Organizador();
        organizador.setRazaoSocial(organizadorRequestDTO.getRazaoSocial());
        organizador.setCnpj(organizadorRequestDTO.getCnpj());

        organizadorRepository.save(organizador);

        return new OrganizadorResponseDTO(organizador);
    }

    public void vincularOrganizador (Long idOrganizador, Long idEvento) {
        Organizador organizador = organizadorRepository.findById(idOrganizador)
                .orElseThrow(() -> new ResourceNotFoundException("Organizador não encontrado com id: " + idOrganizador));
        Evento evento = eventoRepository.findById(idEvento)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com o ID: " + idEvento));

        organizador.getEventosOrganizados().add(evento);
        organizadorRepository.save(organizador);

        evento.setOrganizador(organizador);
        eventoRepository.save(evento);
    }

    public OrganizadorResponseDTO atualizar(Long id, OrganizadorRequestDTO organizadorRequestDTO) {
        Organizador organizador = organizadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organizador não encontrado com id: " + id));

        organizador.setRazaoSocial(organizadorRequestDTO.getRazaoSocial());
        organizador.setCnpj(organizadorRequestDTO.getCnpj());

        organizadorRepository.save(organizador);

        return new OrganizadorResponseDTO(organizador);
    }

    public void deletar(Long id) {
        Organizador organizador = organizadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organizador não encontrado com id: " + id));

        organizador.getEventosOrganizados()
                        .forEach(evento -> evento.setOrganizador(null));
        organizadorRepository.delete(organizador);
    }
}
