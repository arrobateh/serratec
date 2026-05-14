package org.serratec.aula03.cliente.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@JsonPropertyOrder({"id", "nome", "cpf", "email", "dataNascimento"})
@Entity
@Table(name = "cliente", schema = "public")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Size(max = 60, message = "O nome deve ter no maximo 60 caracteres")
    private String nome;

//    @CPF(message = "CPF invalido - informe 11 digitos")
    @Column(name = "cpf", unique = true, length = 11)
    private String cpf;

    @Email(message = "Formato de email invalido")
    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Embedded
    DocumentoCliente documento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public DocumentoCliente getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoCliente documento) {
        this.documento = documento;
    }
}
