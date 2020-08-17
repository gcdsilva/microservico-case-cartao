package br.com.fatura.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE, reason = "Pagamento não disponivel")
public class PagamentoNotAvaibleException extends RuntimeException {
}
