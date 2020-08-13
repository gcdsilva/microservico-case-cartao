package br.com.fatura.controller;

import br.com.fatura.dto.response.ResponseFaturaDTO;
import br.com.fatura.dto.response.ResponseFaturaPagaDTO;
import br.com.fatura.dto.response.ResponseDTO;
import br.com.fatura.entity.FaturaPaga;
import br.com.fatura.mapper.FaturaMapper;
import br.com.fatura.service.FaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/fatura")
public class FaturaController
{
    @Autowired
    FaturaService faturaService;

    @GetMapping("{cliente-id}/{cartao-id}")
    public List<ResponseFaturaDTO> consultaFatura(@PathVariable("cliente-id") String clienteId, @PathVariable("cartao-id") Long cartaoId){
        return faturaService.buscaFaturaPorIdClientCartao(clienteId, cartaoId);
    }

    @PostMapping("{cliente-id}/{cartao-id}/pagar")
    public ResponseFaturaPagaDTO pagarFatura(@PathVariable("cliente-id") String clienteId, @PathVariable("cartao-id") Long cartaoId){

        List<ResponseFaturaDTO> listaFatura = faturaService.buscaFaturaPorIdClientCartao(clienteId, cartaoId);

        BigDecimal valorTotal = null;
        for (ResponseFaturaDTO fatura :listaFatura ) {
            valorTotal.add(fatura.getValor());
        }

        FaturaPaga faturaPaga = new FaturaPaga();
        faturaPaga.setValor(valorTotal);
        faturaPaga.setDataPagamento(new Date());


        return FaturaMapper.faturaPagaToResponseFaturaPaga(faturaService.pagar(faturaPaga));

    };

    @PostMapping("{cliente-id}/{cartao-id}/expirar")
    public ResponseDTO bloqueiaCartao(){
        return  null;

    }
}
