package br.com.fatura.mapper;

import br.com.fatura.dto.response.ResponseFaturaPagaDTO;
import br.com.fatura.entity.FaturaPaga;

public class FaturaMapper {


    public static ResponseFaturaPagaDTO faturaPagaToResponseFaturaPaga(FaturaPaga faturaPaga) {

        ResponseFaturaPagaDTO responseFaturaPagaDTO = new ResponseFaturaPagaDTO();

        responseFaturaPagaDTO.setId(faturaPaga.getId());
        responseFaturaPagaDTO.setPagoEm(faturaPaga.getDataPagamento());
        responseFaturaPagaDTO.setValorPago(faturaPaga.getValor());

        return  responseFaturaPagaDTO;
    }
}
