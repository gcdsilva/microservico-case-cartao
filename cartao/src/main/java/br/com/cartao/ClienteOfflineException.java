package br.com.cartao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Cliente não processado")
public class ClienteOfflineException extends RuntimeException {
}
