package org.serratec.aula.funcionario.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O cargo é obrigatório")
    @Column(name = "cargo")
    private String cargo;

    @Email(message = "Formato de email inválido")
    @Column(name = "email")
    private String email;

    @Column(name = "cidade")
    private String cidade;

    @Size(min = 2, max = 2, message = "A UF deve te rexatamente 2 caracteres")
    @Column(name = "uf")
    private String uf;

    public Funcionario() {
        super();
    }

    public Funcionario(Long id, String nome, String cargo, String email, String cidade, String uf) {
        super();
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.cidade = cidade;
        this.uf = uf;
    }

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}