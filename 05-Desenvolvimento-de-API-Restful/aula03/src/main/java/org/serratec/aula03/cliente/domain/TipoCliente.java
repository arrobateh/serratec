package org.serratec.aula03.cliente.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.serratec.aula03.cliente.exception.EnumValidationException;

public enum TipoCliente {
    PF,
    PJ;

    @JsonCreator
    public static TipoCliente fromValor(String valor) throws EnumValidationException {
        // Se o valor for nulo ou vazio, retorna null
        if (valor == null || valor.isEmpty()) {
            return null;
        }
        // Adapta o texto enviado conforme os valores aceitos
        for (TipoCliente tipo : TipoCliente.values()) {
            if (tipo.name().equalsIgnoreCase(valor)) {
                return tipo;
            }
        }
        throw new EnumValidationException("Tipo de cliente inválido. Valores aceitos: PF, PJ");
    }
}