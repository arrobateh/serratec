package org.serratec.aula03.cliente.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum StatusCliente {
    ATIVO,
    INATIVO,
    BLOQUEADO;

    @JsonCreator
    public static StatusCliente deString(@JsonProperty("status") String status) {
        if (status.equalsIgnoreCase("ATIVO")) {
            return ATIVO;
        }
        if (status.equalsIgnoreCase("INATIVO")) {
            return INATIVO;
        }
        if (status.equalsIgnoreCase("BLOQUEADO")) {
            return BLOQUEADO;
        }
        return null;
    }
}
