package br.com.pagamento.controller;

import br.com.pagamento.controller.entrada.EntradaPagamento;
import br.com.pagamento.entity.Pagamento;
import br.com.pagamento.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
	
	@Autowired
	PagamentoService service;
	
	@PostMapping()
	public ResponseEntity<Pagamento> criar(@RequestBody EntradaPagamento entradaPagamento) {
		return new ResponseEntity<Pagamento>(service.criar(entradaPagamento), new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id_cartao}")
	public List<Pagamento> buscaPorCartao(@PathVariable("id_cartao") String id){
		return service.buscarPorCartao(id);
	}

	@GetMapping("/{cliente-id}/{cartao-id}")
	public List<Pagamento> buscaPorCartaoCliente(@PathVariable("cliente-id") String clienteId, @PathVariable("cartao-id") String cartaoId){
		return service.buscarPorCartaoCliente(clienteId, cartaoId);
	}




}
