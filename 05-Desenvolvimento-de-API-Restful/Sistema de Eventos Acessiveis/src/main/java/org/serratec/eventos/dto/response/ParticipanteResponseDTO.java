package org.serratec.eventos.dto.response;

import lombok.Data;
import org.serratec.eventos.domain.Participante;

import java.time.LocalDate;

@Data
public class ParticipanteResponseDTO {
    private Long id;
    private String nomeParticipante;
    private String email;
    private LocalDate dataNascimento;

    public ParticipanteResponseDTO(Participante participante) {
        this.id = participante.getId();
        this.nomeParticipante = participante.getNomeParticipante();
        this.email = participante.getEmail();
        this.dataNascimento = participante.getDataNascimento();
    }
}
