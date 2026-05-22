package org.serratec.eventos.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.serratec.eventos.domain.CategoriaEvento;

import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonPropertyOrder({"idCategoriaEvento", "nomeCategoriaEvento", "eventos"})
public class CategoriaEventoResponseDTO {
    private Long idCategoriaEvento;
    private String nomeCategoriaEvento;
    private List<String> eventos;

    public CategoriaEventoResponseDTO(CategoriaEvento categoriaEvento) {
        this.idCategoriaEvento = categoriaEvento.getIdCategoriaEvento();
        this.nomeCategoriaEvento = categoriaEvento.getNomeCategoriaEvento();

        if (categoriaEvento.getEventos() != null) {
            this.eventos = categoriaEvento.getEventos().stream()
                    .map(e -> e.getNome())
                    .collect(Collectors.toList());
        }
    }
}
