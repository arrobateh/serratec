package org.serratec.eventos.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RecAcessibilidadeRequestDTO {

    @NotBlank(message = "O nome do recurso de acessibilidade é obrigatório.")
    private String nomeRecursoAcessibilidade;
}
