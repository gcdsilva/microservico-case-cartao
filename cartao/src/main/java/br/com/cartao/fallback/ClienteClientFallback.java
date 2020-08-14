package br.com.cartao.fallback;

import br.com.cartao.client.ClienteClient;
import br.com.cartao.dto.ClienteDTO;
import br.com.cartao.exception.ClienteNotAvailableException;

public class ClienteClientFallback implements ClienteClient {


    @Override
    public ClienteDTO buscarPorId(Long id) {

        throw new ClienteNotAvailableException();

        return null;
    }
}
