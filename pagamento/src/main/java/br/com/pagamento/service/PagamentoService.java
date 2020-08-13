package br.com.pagamento.service;

import br.com.pagamento.client.CartaoClient;
import br.com.pagamento.controller.entrada.EntradaPagamento;
import br.com.pagamento.dto.CartaoDTO;
import br.com.pagamento.entity.Pagamento;
import br.com.pagamento.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PagamentoService {
	
	@Autowired
	PagamentoRepository repository;
	
	@Autowired
	CartaoClient cartaoClient;
	
	public Pagamento criar(EntradaPagamento entradaPagamento) {
		
		CartaoDTO cartao = cartaoClient.buscarPorNumero(entradaPagamento.getCartaoId());

			Pagamento pagamento = new Pagamento();
			pagamento.setCartaoId(cartao.getClienteId());
			pagamento.setDescricao(entradaPagamento.getDescricao());
			pagamento.setValor(entradaPagamento.getValor());
			return repository.save(pagamento);

	}
	
	
	public List<Pagamento> buscarPorCartao(String id) {
		
		List<Pagamento> listaPagamento = repository.buscaPorCartao(id);

		if(listaPagamento.isEmpty()){
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não encontrado nenhum pagamento");
		}
		
		return listaPagamento;
		
	}

}
