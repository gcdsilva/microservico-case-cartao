package br.com.cartao.client;


import br.com.cartao.dto.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente")
public interface ClienteClient {

    @GetMapping("/cliente/{id}")
    public ClienteDTO buscarPorId(@PathVariable Long id);
}
