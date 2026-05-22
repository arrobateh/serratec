package org.serratec.eventos.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Schema(description = "Modelo de dados para cadastrar ou atualizar um novo local")
@Data
public class LocalRequestDTO {

    @Schema(description = "Nome do local", example = "Teatro Municipal", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "O nome do local é obrigatório.")
    private String nomeLocal;

    @Schema(description = "Capacidade máxima que o local suporta", example = "500", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "A capacidade máxima deve ser informada.")
    @Positive(message = "A capacidade máxima deve ser um número positivo.")
    private Integer capacidadeMaxima;
}