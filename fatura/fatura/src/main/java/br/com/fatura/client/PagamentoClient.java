package br.com.fatura.client;

import br.com.fatura.dto.response.ResponseFaturaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(name = "pagamento", configuration = PagamentoClientConfiguration.class)
public interface PagamentoClient {

    @GetMapping("pagamento/{cliente-id}/{cartao-id}")
    List<ResponseFaturaDTO> buscaPorCartao(@PathVariable("cliente-id") String clienteId, @PathVariable("cartao-id") String cartaoId) throws PagamentoNotAvaibleException;
}

