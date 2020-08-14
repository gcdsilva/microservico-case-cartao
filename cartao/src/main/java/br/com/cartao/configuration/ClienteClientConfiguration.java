package br.com.cartao.configuration;

import br.com.cartao.decoder.ClienteClientDecoder;
import br.com.cartao.dto.ClienteDTO;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;

public class ClienteClientConfiguration {

    @Bean
    public ErrorDecoder buscarPorIdDecoder() {
        return new ClienteClientDecoder();
    }
}
