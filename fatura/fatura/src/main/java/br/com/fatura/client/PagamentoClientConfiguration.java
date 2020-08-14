package br.com.fatura.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class PagamentoClientConfiguration {

    @Bean
    public ErrorDecoder buscaPorCartao() {
        return new PagamentoClientDecoder();
    }

}
