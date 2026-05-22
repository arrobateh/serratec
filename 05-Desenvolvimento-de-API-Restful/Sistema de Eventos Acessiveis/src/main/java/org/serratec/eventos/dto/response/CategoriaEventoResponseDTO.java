package org.serratec.eventos.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.serratec.eventos.domain.CategoriaEvento;

import java.util.List;
import java.util.stream.Collectors;

@Schema(description = "Modelo de dados para representar uma categoria de evento")
@Data
@JsonPropertyOrder({"idCategoriaEvento", "nomeCategoriaEvento", "eventos"})
public class CategoriaEventoResponseDTO {
    @Schema(description = "ID da categoria do evento", example = "1")
    private Long idCategoriaEvento;
    @Schema(description = "Nome da categoria do evento", example = "Teatro")
    private String nomeCategoriaEvento;
    @Schema(description = "Lista de eventos vinculados à categoria")
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
