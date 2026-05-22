package org.serratec.eventos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "categoria_evento")
public class CategoriaEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoriaEvento;

    @NotBlank(message = "O nome da categoria do evento é obrigatório.")
    @Size(max = 100, message = "O nome da categoria do evento deve ter no máximo 100 caracteres.")
    private String nomeCategoriaEvento;

    @OneToMany(mappedBy = "categoriaEvento")
    private List<Evento> eventos = new ArrayList<>();
}
