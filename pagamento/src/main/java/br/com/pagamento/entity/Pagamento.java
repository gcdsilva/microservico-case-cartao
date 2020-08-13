package br.com.pagamento.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="pagamento") 
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cartaoId;

    private String descricao;

    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
