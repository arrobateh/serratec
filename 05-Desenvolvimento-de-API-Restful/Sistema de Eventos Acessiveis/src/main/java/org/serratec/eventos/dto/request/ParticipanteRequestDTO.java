package org.serratec.eventos.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ParticipanteRequestDTO {

    @NotBlank(message = "O nome do participante é obrigatório.")
    private String nomeParticipante;

    @Email(message = "O email deve ser válido.")
    private String email;

    @Past(message = "A data de nascimento deve ser no passado.")
    private LocalDate dataNascimento;
}
