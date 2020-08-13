package br.com.fatura.client;

import br.com.fatura.dto.response.ResponseFaturaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(name = "pagamento")
public interface FaturaClient {

    @GetMapping("pagamento/{id_cartao}")
    List<ResponseFaturaDTO> buscaPorCartao(@RequestParam("clienteId") String clienteId, @PathVariable("id_cartao") Long id);
}

