package org.serratec.eventos.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventoRequestDTO {

    @NotBlank(message = "O nome do evento é obrigatório.")
    @Size(max = 100, message = "O nome do evento deve conter no máximo 100 caracteres.")
    private String nome;

    @NotNull(message = "A data do evento é obrigatória.")
    @FutureOrPresent(message = "A data do evento deve ser igual ou posterior à data atual.")
    private LocalDate dataEvento;

    @NotNull(message = "O id do local é obrigatório.")
    private Long idLocal;
}