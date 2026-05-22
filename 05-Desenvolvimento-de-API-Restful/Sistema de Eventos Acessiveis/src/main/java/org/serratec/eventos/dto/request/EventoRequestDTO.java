package org.serratec.eventos.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "Modelo de dados para cadastrar ou atualizar um novo evento")
public class EventoRequestDTO {

    @Schema(description = "Nome do evento", example = "Evento de Tecnologia", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "O nome do evento é obrigatório.")
    @Size(max = 100, message = "O nome do evento deve conter no máximo 100 caracteres.")
    private String nome;

    @Schema(description = "A data em que o evento será agendado.")
    @NotNull(message = "A data do evento é obrigatória.")
    @FutureOrPresent(message = "A data do evento deve ser igual ou posterior à data atual.")
    private LocalDate dataEvento;

    @Schema(description = "ID do local onde o evento será realizado.", example = "1")
    @NotNull(message = "O id do local é obrigatório.")
    private Long idLocal;

    @Schema(description = "ID da categoria do evento.", example = "1")
    @NotNull(message = "O id da categoria do evento é obrigatório.")
    private Long idCategoriaEvento;


}