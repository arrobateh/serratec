package org.serratec.eventos.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.serratec.eventos.domain.Organizador;

import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonPropertyOrder({"idOrganizador", "razaoSocial", "cnpj", "eventosOrganizados"})
public class OrganizadorResponseDTO {

    private Long idOrganizador;
    private String razaoSocial;
    private String cnpj;
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
