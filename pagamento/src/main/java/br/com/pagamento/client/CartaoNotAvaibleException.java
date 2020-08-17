package br.com.pagamento.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE, reason = "Cartao não disponivel")
public class CartaoNotAvaibleException extends RuntimeException {
}
