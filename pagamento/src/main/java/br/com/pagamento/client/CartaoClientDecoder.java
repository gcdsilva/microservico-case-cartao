package br.com.pagamento.client;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CartaoClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if(response.status() == 404) {
            return new CartaoNotFoundException();
        }
        return errorDecoder.decode(s, response);

    }
}
