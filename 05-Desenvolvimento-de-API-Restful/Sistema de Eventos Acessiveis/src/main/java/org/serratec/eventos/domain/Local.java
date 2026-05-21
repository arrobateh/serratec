package org.serratec.eventos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "local")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local")
    private Long id;

    @NotBlank(message = "O nome do local é obrigatório.")
    @Column(name = "nome")
    private String nomeLocal;

    @NotNull(message = "A capacidade máxima deve ser informada.")
    @Column(name = "capacidade_maxima")
    private Integer capacidadeMaxima;

    @OneToMany(mappedBy = "localEvento")
    private List<Evento> eventos;
}
