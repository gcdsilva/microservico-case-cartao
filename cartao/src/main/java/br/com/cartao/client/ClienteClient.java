package br.com.cartao.client;


import br.com.cartao.configuration.ClienteClientConfiguration;
import br.com.cartao.dto.ClienteDTO;
import br.com.cartao.exception.ClienteNotAvailableException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente", configuration = ClienteClientConfiguration.class)
public interface ClienteClient {

    @GetMapping("/cliente/{id}")
    public ClienteDTO buscarPorId(@PathVariable Long id);
}
