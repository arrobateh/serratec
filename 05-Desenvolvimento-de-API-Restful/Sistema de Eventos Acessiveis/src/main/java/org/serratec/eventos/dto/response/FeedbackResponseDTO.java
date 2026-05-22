package org.serratec.eventos.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.serratec.eventos.domain.Feedback;

@Schema(description = "Modelo de dados para representar um feedback")
@Data
@JsonPropertyOrder({"id", "nomeParticipante", "nomeEvento", "comentario", "nota"})
public class FeedbackResponseDTO {
    @Schema(description = "ID do feedback", example = "1")
    private Long id;
    @Schema(description = "Comentário do feedback", example = "Ótimo evento!")
    private String comentario;
    @Schema(description = "Nota do feedback. Aceita valores entre 1 e 5")
    private Integer nota;
    @Schema(description = "Nome do evento alvo do feedback")
    private String nomeEvento;
    @Schema(description = "Nome do participante que fez o feedback")
    private String nomeParticipante;

    public FeedbackResponseDTO(Feedback feedback) {
        this.id = feedback.getId();
        this.comentario = feedback.getComentario();
        this.nota = feedback.getNota();
        this.nomeEvento = feedback.getEvento() != null ? feedback.getEvento().getNome() : null;
        this.nomeParticipante = feedback.getParticipante() != null ? feedback.getParticipante().getNomeParticipante() : null;
    }
}
