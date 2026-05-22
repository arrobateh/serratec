package org.serratec.eventos.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Modelo de dados para cadastrar ou atualizar uma nova categoria de evento")
public class CategoriaEventoRequestDTO {

    @Schema(description = "Nome da categoria do evento", example = "Tecnologia", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "O nome da categoria do evento é obrigatório.")
    @Size(max = 100, message = "O nome da categoria do evento deve ter no máximo 100 caracteres.")
    private String nomeCategoriaEvento;
}
