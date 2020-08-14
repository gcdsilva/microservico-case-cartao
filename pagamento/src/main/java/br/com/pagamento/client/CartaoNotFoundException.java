package br.com.pagamento.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cartao não encontrado")
public class CartaoNotFoundException extends Exception {
}
