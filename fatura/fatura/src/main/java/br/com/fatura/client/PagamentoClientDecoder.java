package br.com.fatura.client;

import feign.Response;
import feign.codec.ErrorDecoder;

public class PagamentoClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if(response.status() == 404) {
            return new PagamentoNotFoundException();
        }
        return errorDecoder.decode(s, response);

    }
}
