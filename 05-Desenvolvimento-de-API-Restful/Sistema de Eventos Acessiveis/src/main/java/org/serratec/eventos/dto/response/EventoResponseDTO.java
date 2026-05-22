package org.serratec.eventos.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.serratec.eventos.domain.Evento;
import org.serratec.eventos.domain.Feedback;
import org.serratec.eventos.domain.Participante;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Schema(description = "Modelo de dados para representar um evento")
@Data
@JsonPropertyOrder({"id", "nome", "dataEvento", "localEvento", "NomeCategoria", "organizador", "recursosAcessibilidade", "qtdInscritos", "nomesParticipantes", "feedbacks", })
public class EventoResponseDTO {
    @Schema(description = "ID do evento", example = "1")
    private Long id;
    @Schema(description = "Nome do evento", example = "Teatro Municipal")
    private String nome;
    @Schema(description = "Data em que o evento foi agendado")
    private LocalDate dataEvento;
    @Schema(description = "Local do evento")
    private LocalResponseDTO localEvento;
    @Schema(description = "Lista de nomes dos participantes")
    private List<String> nomesParticipantes;
    @Schema(description = "Quantidade de inscritos no evento")
    private int qtdInscritos;
    @Schema(description = "Lista de feedbacks do evento")
    private List<String> feedbacks;
    @Schema(description = "Lista de recursos de acessibilidade do evento")
    private List<RecAcessibilidadeResponseDTO> recursosAcessibilidade;
    @Schema(description = "Razão social do organizador do evento")
    private String organizador;
    @Schema(description = "Nome da categoria do evento")
    private String NomeCategoria;


    public EventoResponseDTO(Evento evento) {
        this.id = evento.getId();
        this.nome = evento.getNome();
        this.dataEvento = evento.getDataEvento();
        this.qtdInscritos = evento.getParticipantes() != null ? evento.getParticipantes().size() : 0;
//        this.organizador = evento.getOrganizador().getRazaoSocial();
        this.NomeCategoria = evento.getCategoriaEvento() != null ? evento.getCategoriaEvento().getNomeCategoriaEvento() : "Sem categoria vinculada";

        if (evento.getLocalEvento() != null) {
            this.localEvento = new LocalResponseDTO(evento.getLocalEvento());
        }

        if (evento.getParticipantes() != null) {
            this.nomesParticipantes = evento.getParticipantes().stream()
                    .map(Participante::getNomeParticipante)
                    .collect(Collectors.toList());
        }

        if (evento.getFeedbacks() != null) {
            this.feedbacks = evento.getFeedbacks().stream()
                    .map(f -> f.getParticipante().getNomeParticipante() + ": " + f.getComentario())
                    .collect(Collectors.toList());
        }
//        Opção 2
//        Obs: alterar o tipo do atributo feedbacks para List<FeedbackResponseDTO>
//        if (evento.getFeedbacks() != null) {
//            this.feedbacks = evento.getFeedbacks().stream()
//                    .map(FeedbackResponseDTO::new)
//                    .collect(Collectors.toList());
//        }
        if (evento.getRecursosAcessibilidade() != null) {
            this.recursosAcessibilidade = evento.getRecursosAcessibilidade().stream()
                    .map(RecAcessibilidadeResponseDTO::new)
                    .collect(Collectors.toList());
        }
        if (evento.getOrganizador() != null) {
            this.organizador = evento.getOrganizador().getRazaoSocial();
        }
        this.organizador = "Sem organizador vinculado";
    }
}
