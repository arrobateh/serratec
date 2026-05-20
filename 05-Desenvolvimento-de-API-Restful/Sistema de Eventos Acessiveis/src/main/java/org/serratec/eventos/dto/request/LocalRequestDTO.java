package org.serratec.eventos.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class LocalRequestDTO {

    @NotBlank(message = "O nome do local é obrigatório.")
    private String nomeLocal;

    @NotNull(message = "A capacidade máxima deve ser informada.")
    @Positive(message = "A capacidade máxima deve ser um número positivo.")
    private Integer capacidadeMaxima;
}
