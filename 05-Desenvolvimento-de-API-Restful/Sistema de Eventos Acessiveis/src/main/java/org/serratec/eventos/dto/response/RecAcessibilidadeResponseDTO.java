package org.serratec.eventos.dto.response;

import lombok.Data;

@Data
public class RecAcessibilidadeResponseDTO {
    private Long id;
    private String nomeRecursoAcessibilidade;

    public RecAcessibilidadeResponseDTO(org.serratec.eventos.domain.RecursoAcessibilidade recurso) {
        this.id = recurso.getId();
        this.nomeRecursoAcessibilidade = recurso.getNomeRecursoAcessibilidade();
    }

}
