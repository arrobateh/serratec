package org.serratec.eventos.dto.response;

import lombok.Data;
import org.serratec.eventos.domain.Evento;
import org.serratec.eventos.domain.Participante;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ParticipanteResponseDTO {
    private Long id;
    private String nomeParticipante;
    private String email;
    private LocalDate dataNascimento;
    private List<String> eventosInscritos;

    public ParticipanteResponseDTO(Participante participante) {
        this.id = participante.getId();
        this.nomeParticipante = participante.getNomeParticipante();
        this.email = participante.getEmail();
        this.dataNascimento = participante.getDataNascimento();

        if (participante.getEventoCadastrado() != null) {
            this.eventosInscritos = participante.getEventoCadastrado().stream()
                    .map(Evento::getNome)
                    .collect(Collectors.toList());
        }
    }
}
