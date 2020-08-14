package br.com.cartao.decoder;

import br.com.cartao.exception.ClienteNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ClienteClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if(response.status() == 404) {
            return new ClienteNotFoundException();
        }
        return errorDecoder.decode(s, response);

    }
}
