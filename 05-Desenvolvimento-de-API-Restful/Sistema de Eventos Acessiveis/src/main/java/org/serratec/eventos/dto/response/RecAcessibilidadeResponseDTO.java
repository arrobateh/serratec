package org.serratec.eventos.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"id", "nomeRecursoAcessibilidade"})
public class RecAcessibilidadeResponseDTO {
    private Long id;
    private String nomeRecursoAcessibilidade;

    public RecAcessibilidadeResponseDTO(org.serratec.eventos.domain.RecursoAcessibilidade recurso) {
        this.id = recurso.getId();
        this.nomeRecursoAcessibilidade = recurso.getNomeRecursoAcessibilidade();
    }

}
