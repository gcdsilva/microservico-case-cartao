package br.com.pagamento.client;

import br.com.pagamento.dto.CartaoDTO;

public class CartaoClientFallback implements CartaoClient{

    @Override
    public CartaoDTO buscarPorNumero(String id) {

        throw new CartaoNotAvaibleException();

    }
}
