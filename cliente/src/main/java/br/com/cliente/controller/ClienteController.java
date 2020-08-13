package br.com.cliente.controller;

import br.com.cliente.entity.Cliente;
import br.com.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService service;

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable("id") Long id) {
		return new ResponseEntity<Cliente>(service.buscarPorId(id), new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
		return new ResponseEntity<Cliente>(service.criar(cliente), new HttpHeaders(), HttpStatus.CREATED);
	}

}
