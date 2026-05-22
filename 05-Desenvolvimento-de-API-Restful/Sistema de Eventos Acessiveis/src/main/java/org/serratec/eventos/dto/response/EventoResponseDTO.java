package org.serratec.eventos.dto.response;

import lombok.Data;
import org.serratec.eventos.domain.Evento;
import org.serratec.eventos.domain.Feedback;
import org.serratec.eventos.domain.Participante;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class EventoResponseDTO {
    private Long id;
    private String nome;
    private LocalDate dataEvento;
    private LocalResponseDTO localEvento;
    private List<String> nomesParticipantes;
    private int qtdInscritos;
    private List<String> feedbacks;
    private List<RecAcessibilidadeResponseDTO> recursosAcessibilidade;
    private String organizador;
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
