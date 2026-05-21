package org.serratec.eventos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_feedback")
    private Long id;

    @NotBlank(message = "O comentário é obrigatório.")
    @Column(name = "comentario")
    private String comentario;

    @NotNull(message = "A nota é obrigatória.")
    @Min(value = 1, message = "Valor inválido. Digite sua nota entre 1 e 5")
    @Max(value = 5, message = "Valor inválido. Digite sua nota entre 1 e 5")
    @Column(name = "nota")
    private Integer nota;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "id_participante")
    private Participante participante;
}
