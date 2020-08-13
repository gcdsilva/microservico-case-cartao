package br.com.cliente.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="cliente") 
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long clienteId;

	@NotNull
    private String name;
	

	public Cliente() {
	}

	public Cliente(Long clienteId, String name) {
		this.clienteId = clienteId;
		this.name = name;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
