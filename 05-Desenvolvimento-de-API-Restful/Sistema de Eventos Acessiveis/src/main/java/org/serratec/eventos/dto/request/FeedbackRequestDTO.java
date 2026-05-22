package org.serratec.eventos.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(description = "Modelo de dados para cadastrar um novo feedback")
public class FeedbackRequestDTO {

    @Schema(description = "Comentário do feedback", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "O comentário é obrigatório.")
    private String comentario;

    @Schema(description = "Nota do feedback. Aceita valores entre 1 e 5", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "A nota é obrigatória.")
    private Integer nota;

    @Schema(description = "ID do evento associado ao feedback", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "O ID do evento é obrigatório.")
    private Long idEvento;

    @Schema(description = "ID do participante associado ao feedback", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "O ID do participante é obrigatório.")
    private Long idParticipante;
}
