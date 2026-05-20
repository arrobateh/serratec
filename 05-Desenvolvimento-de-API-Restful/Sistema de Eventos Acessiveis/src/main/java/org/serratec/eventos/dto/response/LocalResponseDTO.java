package org.serratec.eventos.dto.response;

import lombok.Data;
import org.serratec.eventos.domain.Local;

@Data
public class LocalResponseDTO {
    private Long id;
    private String nomeLocal;
    private Integer capacidadeMaxima;

    public LocalResponseDTO(Local local) {
        this.id = local.getId();
        this.nomeLocal = local.getNomeLocal();
        this.capacidadeMaxima = local.getCapacidadeMaxima();
    }
}
