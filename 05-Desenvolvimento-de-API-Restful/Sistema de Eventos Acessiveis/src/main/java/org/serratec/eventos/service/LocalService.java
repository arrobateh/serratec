package org.serratec.eventos.service;

import org.serratec.eventos.domain.Local;
import org.serratec.eventos.dto.request.LocalRequestDTO;
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

    public List<LocalResponseDTO> listarTodos() {
        return localRepository.findAll().stream()
                .map(LocalResponseDTO::new)
                .collect(Collectors.toList());
    }

    public LocalResponseDTO buscarPorId(Long id) {
        Local localEvento = localRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Local não encontrado com id: " + id));
        return new LocalResponseDTO(localEvento);
    }

    public LocalResponseDTO salvar(LocalRequestDTO localRequestDTO) {
        Local local = new Local();
        local.setNomeLocal(localRequestDTO.getNomeLocal());
        local.setCapacidadeMaxima(localRequestDTO.getCapacidadeMaxima());

        local = localRepository.save(local);

        return new LocalResponseDTO(local);
    }

    public LocalResponseDTO atualizar(Long id, LocalRequestDTO localRequestDTO) {
        Local local = localRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Local não encontrado com id: " + id));

        local.setNomeLocal(localRequestDTO.getNomeLocal());
        local.setCapacidadeMaxima(localRequestDTO.getCapacidadeMaxima());

        localRepository.save(local);

        return new LocalResponseDTO(local);
    }

    public void deletar(Long id) {
        if (!localRepository.existsById(id)) {
            throw new RuntimeException("Impossivel deletar. Local não encontrado com id: " + id);
        }
        localRepository.deleteById(id);
    }
}
