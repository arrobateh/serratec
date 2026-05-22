package org.serratec.eventos.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Modelo de dados para cadastrar ou atualizar um novo recurso de acessibilidade")
@Data
public class RecAcessibilidadeRequestDTO {

    @Schema(description = "Nome do recurso de acessibilidade", example = "Intérprete de Libras", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "O nome do recurso de acessibilidade é obrigatório.")
    private String nomeRecursoAcessibilidade;
}
