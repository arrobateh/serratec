package org.serratec.eventos.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrganizadorRequestDTO {

    @NotBlank(message = "A razão social é obrigatória.")
    @Column(name = "razao_social")
    private String razaoSocial;

    @NotBlank(message = "O nome CNPJ é obrigatório.")
    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter 14 dígitos números.")
    @Column(name = "cnpj")
    private String cnpj;
}
