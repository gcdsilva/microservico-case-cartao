package br.com.cartao.controller;


import br.com.cartao.controller.entrada.EntradaCartao;
import br.com.cartao.entity.Cartao;
import br.com.cartao.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartao")
public class CartaoController {
	
	@Autowired
	CartaoService service;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cartao> criar(@RequestBody EntradaCartao entradaCartao) {
		return new ResponseEntity<Cartao>(service.criar(entradaCartao), new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@PatchMapping("/{numero}")
	public ResponseEntity<Cartao> atualizar(@PathVariable("numero") String numero, @RequestBody EntradaCartao entradaCarta) {
		 
		return new ResponseEntity<Cartao>(service.atualizar(numero, entradaCarta), new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{numero}")
	public Cartao buscarPorNumero(@PathVariable("numero") String id) {

		Optional<Cartao> optionalCartao = service.buscaPorNumero(id).stream().findFirst();

		return optionalCartao.get();
	}


	@GetMapping("/{idCliente}/{idCartao}")
	public Cartao buscaPorClienteCartao(@PathVariable("idCliente") String idCliente, @PathVariable("idCartao") String idCartao){

		Optional<Cartao> optionalCartao = service.buscaPorClienteCartao(idCartao, idCliente).stream().findFirst();

		return optionalCartao.get();
	}


}
