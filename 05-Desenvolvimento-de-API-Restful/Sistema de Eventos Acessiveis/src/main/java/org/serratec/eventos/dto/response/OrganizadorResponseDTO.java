package org.serratec.eventos.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.serratec.eventos.domain.Organizador;

import java.util.List;
import java.util.stream.Collectors;

@Schema(description = "Modelo de dados para representar um organizador")
@Data
@JsonPropertyOrder({"idOrganizador", "razaoSocial", "cnpj", "eventosOrganizados"})
public class OrganizadorResponseDTO {

    @Schema(description = "ID do organizador", example = "1")
    private Long idOrganizador;
    @Schema(description = "Razão social do organizador do evento")
    private String razaoSocial;
    @Schema(description = "CNPJ do organizador do evento")
    private String cnpj;
    @Schema(description = "Lista de eventos organizados pelo organizador")
    private List<String> eventosOrganizados;

    public OrganizadorResponseDTO(Organizador organizador) {
        this.idOrganizador = organizador.getIdOrganizador();
        this.razaoSocial = organizador.getRazaoSocial();
        this.cnpj = organizador.getCnpj();

        if (organizador.getEventosOrganizados() != null) {
            this.eventosOrganizados = organizador.getEventosOrganizados().stream()
                    .map(e -> e.getNome())
                    .collect(Collectors.toList());
        }
    }
}
