package org.serratec.eventos.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.serratec.eventos.domain.Local;

@Schema(description = "Modelo de dados para representar um local")
@Data
@JsonPropertyOrder({"id", "nomeLocal", "capacidadeMaxima"})
public class LocalResponseDTO {
    @Schema(description = "ID do local", example = "1")
    private Long id;
    @Schema(description = "Nome do local do evento", example = "Teatro Municipal")
    private String nomeLocal;
    @Schema(description = "Capacidade máxima do local do evento")
    private Integer capacidadeMaxima;

    public LocalResponseDTO(Local local) {
        this.id = local.getId();
        this.nomeLocal = local.getNomeLocal();
        this.capacidadeMaxima = local.getCapacidadeMaxima();
    }
}
