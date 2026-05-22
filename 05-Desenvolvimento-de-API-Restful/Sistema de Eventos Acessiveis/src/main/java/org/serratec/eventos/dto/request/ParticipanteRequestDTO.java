package org.serratec.eventos.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Schema(description = "Modelo de dados para cadastrar ou atualizar um novo participante")
@Data
public class ParticipanteRequestDTO {

    @Schema(description = "Nome do participante", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "O nome do participante é obrigatório.")
    private String nomeParticipante;

    @Schema(description = "Email do participante", requiredMode = Schema.RequiredMode.REQUIRED)
    @Email(message = "O email deve ser válido.")
    private String email;

    @Schema(description = "Data de nascimento do participante", requiredMode = Schema.RequiredMode.REQUIRED)
    @Past(message = "A data de nascimento deve ser no passado.")
    private LocalDate dataNascimento;
}