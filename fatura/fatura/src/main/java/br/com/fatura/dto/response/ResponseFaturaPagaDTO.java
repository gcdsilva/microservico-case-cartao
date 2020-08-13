package br.com.fatura.dto.response;

import java.math.BigDecimal;
import java.util.Date;

public class ResponseFaturaPagaDTO {

    private String id;

    private BigDecimal valorPago;

    private Date pagoEm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public Date getPagoEm() {
        return pagoEm;
    }

    public void setPagoEm(Date pagoEm) {
        this.pagoEm = pagoEm;
    }
}
