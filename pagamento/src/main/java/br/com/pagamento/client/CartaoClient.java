package br.com.pagamento.client;

import br.com.pagamento.dto.CartaoDTO;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cartao")
public interface CartaoClient {

    @GetMapping("/cartao/{numero}")
    public CartaoDTO buscarPorNumero(@PathVariable("numero") String id);


}
