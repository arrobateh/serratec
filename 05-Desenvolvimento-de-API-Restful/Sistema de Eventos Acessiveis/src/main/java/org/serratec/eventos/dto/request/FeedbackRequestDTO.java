package org.serratec.eventos.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class FeedbackRequestDTO {

    @NotBlank(message = "O comentário é obrigatório.")
    private String comentario;

    @NotNull(message = "A nota é obrigatória.")
    private Integer nota;

    @NotNull(message = "O ID do evento é obrigatório.")
    private Long idEvento;

    @NotNull(message = "O ID do participante é obrigatório.")
    private Long idParticipante;
}
