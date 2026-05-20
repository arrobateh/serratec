package org.serratec.eventos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Long id;

    @Size(min = 1, max = 100, message = "O nome do evento deve conter entre 1 e 100 caracteres.")
    @NotBlank(message = "O nome do evento é obrigatório.")
    @Column(name = "nome")
    private String nome;

    @NotNull(message = "A data do evento é obrigatória.")
    @Column(name = "data_evento")
    private LocalDate dataEvento;

    @ManyToOne
    @JoinColumn(name = "id_local_evento")
    private Local localEvento;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "evento_recurso",
            joinColumns = @JoinColumn(name = "id_evento"),
            inverseJoinColumns = @JoinColumn(name = "id_recurso_acessibilidade")
    )
    private List<RecursoAcessibilidade> recursoAcessibilidade;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

}
