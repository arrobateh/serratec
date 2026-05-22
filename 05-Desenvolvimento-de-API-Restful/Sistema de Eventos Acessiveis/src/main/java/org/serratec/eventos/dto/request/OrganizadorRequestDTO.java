package org.serratec.eventos.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Modelo de dados para cadastrar ou atualizar um novo organizador")
@Data
public class OrganizadorRequestDTO {

    @Schema(description = "Razão social do organizador", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "A razão social é obrigatória.")
    @Column(name = "razao_social")
    private String razaoSocial;

    @Schema(description = "CNPJ do organizador")
    @NotBlank(message = "O nome CNPJ é obrigatório.")
    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter 14 dígitos números.")
    @Column(name = "cnpj")
    private String cnpj;
}
