package br.com.fatura.client;

import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class PagamentoClientConfiguration {

    @Bean
    public ErrorDecoder buscaPorCartao() {
        return new PagamentoClientDecoder();
    }

    @Bean
    public Feign.Builder builder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new PagamentoClientFallback(), RetryableException.class)
                .build();

        return Resilience4jFeign.builder(decorators);
    }


}
