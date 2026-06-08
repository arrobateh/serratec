package com.aula05.aula05.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "A placa é obrigatória")
    @Size(min = 7, max = 7, message = "A placa deve conter exatamente 7 caracteres")
    @Column(name = "placa")
    private String placa;

    @NotBlank(message = "A marca é obrigatória")
    @Column(name = "marca")
    private String marca;

    @NotBlank(message = "O modelo é obrigatório")
    @Size(max = 40, message = "O tamanho maximo de caracteres é 40")
    @Column(name = "modelo")
    private String modelo;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    public Veiculo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
