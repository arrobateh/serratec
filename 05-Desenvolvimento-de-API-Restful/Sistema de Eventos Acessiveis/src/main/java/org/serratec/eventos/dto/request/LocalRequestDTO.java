package org.serratec.eventos.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class LocalRequestDTO {

    @NotNull(message = "O ID do local deve ser informado para atualização.")
    private Long id;

    @NotBlank(message = "O nome do local é obrigatório.")
    private String nomeLocal;

    @NotNull(message = "A capacidade máxima deve ser informada.")
    @Positive(message = "A capacidade máxima deve ser um número positivo.")
    private Integer capacidadeMaxima;
}
