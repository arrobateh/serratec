package org.serratec.eventos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "participante")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do participante é obrigatório.")
    private String nomeParticipante;

    @Email(message = "O email deve ser válido.")
    private String email;

    @Past(message = "A data de nascimento deve ser no passado.")
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento eventoCadastrado;
}
