package org.serratec.eventos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

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

    @Column(name = "capacidade_maxima")
    private Integer capacidadeMaxima;
}
