package org.serratec.eventos.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.serratec.eventos.domain.Feedback;

@Data
@JsonPropertyOrder({"id", "nomeParticipante", "nomeEvento", "comentario", "nota"})
public class FeedbackResponseDTO {
    private Long id;
    private String comentario;
    private Integer nota;
    private String nomeEvento;
    private String nomeParticipante;

    public FeedbackResponseDTO(Feedback feedback) {
        this.id = feedback.getId();
        this.comentario = feedback.getComentario();
        this.nota = feedback.getNota();
        this.nomeEvento = feedback.getEvento() != null ? feedback.getEvento().getNome() : null;
        this.nomeParticipante = feedback.getParticipante() != null ? feedback.getParticipante().getNomeParticipante() : null;
    }
}
