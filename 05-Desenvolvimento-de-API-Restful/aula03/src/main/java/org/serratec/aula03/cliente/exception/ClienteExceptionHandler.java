package org.serratec.aula03.cliente.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ClienteExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body("Erro na validação dos campos.");
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {

        // 1. Investigamos qual foi a "causa raiz" do erro
        Throwable causaRaiz = ex.getRootCause();

        // 2. Se a causa raiz for a nossa exceção do Enum, nós pegamos a mensagem dela!
        if (causaRaiz instanceof EnumValidationException) {
            return ResponseEntity.badRequest().body(causaRaiz.getMessage());
        }

        // 3. Se for qualquer outro erro de JSON (uma vírgula faltando, por exemplo), cai aqui
        return ResponseEntity.badRequest().body("Formato de Json invalido");
    }
}
