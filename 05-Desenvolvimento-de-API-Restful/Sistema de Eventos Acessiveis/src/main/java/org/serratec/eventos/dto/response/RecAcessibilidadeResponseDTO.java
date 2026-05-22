package org.serratec.eventos.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Modelo de dados para representar um recurso de acessibilidade")
@Data
@JsonPropertyOrder({"id", "nomeRecursoAcessibilidade"})
public class RecAcessibilidadeResponseDTO {
    @Schema(description = "ID do recurso de acessibilidade", example = "1")
    private Long id;
    @Schema(description = "Nome do recurso de acessibilidade", example = "Intérprete de Libras")
    private String nomeRecursoAcessibilidade;

    public RecAcessibilidadeResponseDTO(org.serratec.eventos.domain.RecursoAcessibilidade recurso) {
        this.id = recurso.getId();
        this.nomeRecursoAcessibilidade = recurso.getNomeRecursoAcessibilidade();
    }

}
