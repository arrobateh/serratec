package org.serratec.eventos.dto.response;

import lombok.Data;
import org.serratec.eventos.domain.Evento;

import java.time.LocalDate;

@Data
public class EventoResponseDTO {
    private Long id;
    private String nome;
    private LocalDate dataEvento;
    private LocalResponseDTO localEvento;

    public EventoResponseDTO(Evento evento) {
        this.id = evento.getId();
        this.nome = evento.getNome();
        this.dataEvento = evento.getDataEvento();

        if(evento.getLocalEvento() != null) {
            this.localEvento = new LocalResponseDTO(evento.getLocalEvento());
        }
    }
}
