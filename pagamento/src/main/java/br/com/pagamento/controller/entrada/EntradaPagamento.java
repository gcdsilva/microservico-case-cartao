package br.com.pagamento.controller.entrada;

import java.math.BigDecimal;

public class EntradaPagamento {
	
	private String  cartaoId;
	
	private String descricao;
	
	private BigDecimal valor;

	public String getCartaoId() {
		return cartaoId;
	}

	public void setCartaoId(String cartaoId) {
		this.cartaoId = cartaoId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	

}
