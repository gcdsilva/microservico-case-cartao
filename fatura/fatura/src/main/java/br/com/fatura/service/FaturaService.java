package br.com.fatura.service;


import br.com.fatura.client.FaturaClient;
import br.com.fatura.dto.response.ResponseFaturaDTO;
import br.com.fatura.entity.FaturaPaga;
import br.com.fatura.repository.FaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaturaService {


    @Autowired
    FaturaClient faturaClient;

    @Autowired
    FaturaRepository faturaRepository;


    public List<ResponseFaturaDTO> buscaFaturaPorIdClientCartao( String clienteId, Long cartaoId){
        return faturaClient.buscaPorCartao(clienteId, cartaoId);
    }

    public FaturaPaga pagar(FaturaPaga faturaPaga){

        return faturaRepository.save(faturaPaga);
    }
}
