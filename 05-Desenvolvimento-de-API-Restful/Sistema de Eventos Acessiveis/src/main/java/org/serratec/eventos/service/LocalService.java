package org.serratec.eventos.service;

import org.serratec.eventos.domain.Local;
import org.serratec.eventos.dto.request.LocalResquestDTO;
import org.serratec.eventos.dto.response.LocalResponseDTO;
import org.serratec.eventos.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalService {
    @Autowired
    private LocalRepository localRepository;

    public LocalResponseDTO salvar(LocalResquestDTO localRequestDTO) {
        Local local = new Local();
        local.setNomeLocal(localRequestDTO.getNomeLocal());
        local.setCapacidadeMaxima(localRequestDTO.getCapacidadeMaxima());

        local = localRepository.save(local);

        return new LocalResponseDTO(local);
    }

    public List<LocalResponseDTO> listarTodos() {
        return localRepository.findAll().stream()
                .map(LocalResponseDTO::new)
                .collect(Collectors.toList());
    }
}
