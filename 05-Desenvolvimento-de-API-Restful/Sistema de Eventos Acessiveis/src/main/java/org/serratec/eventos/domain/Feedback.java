package org.serratec.eventos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id-feedback")
    private Long id;

    @NotBlank(message = "O comentário é obrigatório.")
    @Column(name = "comentario")
    private String comentario;

    @Size(max = 1, message = "Valor inválido. Digite sua nota entre 1 e 5")
    @Column(name = "nota")
    private Integer nota;

    @ManyToOne
    @JoinColumn(name = "id-evento")
    private Evento evento;
}
