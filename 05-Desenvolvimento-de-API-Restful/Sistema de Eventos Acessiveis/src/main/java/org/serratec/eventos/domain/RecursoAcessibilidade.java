package org.serratec.eventos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "recurso_acessibilidade")
public class RecursoAcessibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id-recurso-acessibilidade")
    private Long id;

    @NotBlank(message = "O nome do recurso de acessibilidade é obrigatório.")
    @Size(max = 100)
    @Column(name = "nome")
    private String nomeRecursoAcessibilidade;
}
