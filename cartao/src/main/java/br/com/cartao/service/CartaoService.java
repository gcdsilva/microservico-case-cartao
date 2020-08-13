package br.com.cartao.service;

import br.com.cartao.client.ClienteClient;
import br.com.cartao.controller.entrada.EntradaCartao;
import br.com.cartao.dto.ClienteDTO;
import br.com.cartao.entity.Cartao;
import br.com.cartao.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CartaoService {

	@Autowired
	CartaoRepository repository;

	@Autowired
	ClienteClient clienteClient;

	public Cartao criar(EntradaCartao entradaCartao) {

		ClienteDTO cliente = clienteClient.buscarPorId(entradaCartao.getClienteId());

		Cartao cartao = new Cartao();
		cartao.setNumero(entradaCartao.getNumero());
		cartao.setClienteId(cliente.getClienteId());
		return repository.save(cartao);
	}


	public Cartao buscarPorId(Long id) {
		Optional<Cartao> optionalCartao = repository.findById(id);

		return optionalCartao.get();
	}

	public Cartao atualizar(String numeroCartao, EntradaCartao entradaCartao) {
		List<Cartao> listaCartao = repository.buscaPorNumero(numeroCartao);

		Optional<Cartao> optionalCartao = listaCartao.stream().findFirst();

		if (optionalCartao.isPresent()) {
			Cartao cartaoRetornado = optionalCartao.get();
			cartaoRetornado.setAtivo(entradaCartao.isAtivo());

			Cartao cartao = repository.save(cartaoRetornado);
			return cartao;
		}

		throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possivel atualizar - cartão não encontrado");

	}

	public List<Cartao> buscaPorNumero(String numeroCartao){

		List<Cartao> listaCartao = repository.buscaPorNumero(numeroCartao);
		return listaCartao;
	}

	public List<Cartao> buscaPorClienteCartao(String idCliente, String idCartao) {
		List<Cartao> listaCartao = repository.buscaPorIdClienteCartao(idCliente, idCartao);
		return listaCartao;

	}
}
