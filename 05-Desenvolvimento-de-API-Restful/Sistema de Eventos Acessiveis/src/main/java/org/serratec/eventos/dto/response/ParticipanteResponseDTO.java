package org.serratec.eventos.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.serratec.eventos.domain.Evento;
import org.serratec.eventos.domain.Participante;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Schema(description = "Modelo de dados para representar um participante")
@Data
@JsonPropertyOrder({"id", "nomeParticipante", "email", "dataNascimento", "eventosInscritos"})
public class ParticipanteResponseDTO {
    @Schema(description = "ID do participante", example = "1")
    private Long id;
    @Schema(description = "Nome do participante", example = "João Silva")
    private String nomeParticipante;
    @Schema(description = "Email do participante")
    private String email;
    @Schema(description = "Data de nascimento do participante")
    private LocalDate dataNascimento;
    @Schema(description = "Lista de eventos em que o participante está inscrito")
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
