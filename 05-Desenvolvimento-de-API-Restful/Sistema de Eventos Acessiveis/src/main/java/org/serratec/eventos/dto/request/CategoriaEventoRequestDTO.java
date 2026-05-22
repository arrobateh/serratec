package org.serratec.eventos.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoriaEventoRequestDTO {

    @NotBlank(message = "O nome da categoria do evento é obrigatório.")
    @Size(max = 100, message = "O nome da categoria do evento deve ter no máximo 100 caracteres.")
    private String nomeCategoriaEvento;
}
