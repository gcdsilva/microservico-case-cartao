package br.com.fatura.client;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Pagamento não encontrado")
public class PagamentoNotFoundException extends Exception {
}
