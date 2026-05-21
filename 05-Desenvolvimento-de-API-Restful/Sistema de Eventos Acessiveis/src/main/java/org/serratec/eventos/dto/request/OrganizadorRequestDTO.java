package org.serratec.eventos.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrganizadorRequestDTO {

    @NotBlank(message = "A razão social é obrigatória.")
    @Column(name = "razao_social")
    private String razaoSocial;

    @NotBlank(message = "O nome CNPJ é obrigatório.")
    @Size(min = 14, max = 14, message = "O CNPJ deve conter 14 dígitos.")
    @Column(name = "cnpj")
    private String cnpj;
}
