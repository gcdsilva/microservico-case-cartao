package br.com.fatura.client;

import br.com.fatura.dto.response.ResponseFaturaDTO;

import java.util.List;

public class PagamentoClientFallback implements PagamentoClient {
    @Override
    public List<ResponseFaturaDTO> buscaPorCartao(String clienteId, String cartaoId) {
        throw new PagamentoNotAvaibleException();
    }
}
