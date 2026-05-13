package com.games.exerciciogames.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "jogo", schema = "exercicio-games")
public class Jogo {

    @Id
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "titulo", nullable = false)
    private String titulo;

    @Column (name = "genero")
    private String genero;

    @Column (name = "plataforma")
    private String plataforma;

    @Column (name = "preco")
    private Double preco;
}
