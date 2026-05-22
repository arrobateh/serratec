package org.serratec.eventos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

@Data
@Entity
@Table(name = "organizador")
public class Organizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_organizador")
    private Long idOrganizador;

    @NotBlank(message = "A razão social é obrigatória.")
    @Column(name = "razao_social")
    private String razaoSocial;

    @NotBlank(message = "O nome CNPJ é obrigatório.")
    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter apenas números.")
    @Size(min = 14, max = 14, message = "O CNPJ deve conter 14 dígitos.")
    @Column(name = "cnpj")
    private String cnpj;

    @OneToMany(mappedBy = "organizador")
    private List<Evento> eventosOrganizados;
}
