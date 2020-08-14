package br.com.cartao.configuration;

import br.com.cartao.decoder.ClienteClientDecoder;
import br.com.cartao.dto.ClienteDTO;
import br.com.cartao.fallback.ClienteClientFallback;
import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;

public class ClienteClientConfiguration {

    @Bean
    public ErrorDecoder buscarPorIdDecoder() {
        return new ClienteClientDecoder();
    }

    @Bean
    public Feign.Builder builder(){
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new ClienteClientFallback(), RetryableException.class)
                .build();

        return Resilience4jFeign.builder(decorators);

    }
}
