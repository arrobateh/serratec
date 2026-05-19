package org.serratec.eventos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id-evento")
    private Long id;

    @Size(min = 1, max = 100, message = "O nome do evento deve conter entre 1 e 100 caracteres.")
    @NotBlank(message = "O nome do evento é obrigatório.")
    @Column(name = "nome-evento")
    private String nome;

    @NotNull(message = "A data do evento é obrigatória.")
    @Column(name = "data-evento")
    private LocalDate dataEvento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id-local-evento")
    private Local localEvento;

}
