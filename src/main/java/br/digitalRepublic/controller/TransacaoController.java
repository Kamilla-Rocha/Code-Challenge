package br.digitalRepublic.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.digitalRepublic.Exception.DefaultException;
import br.digitalRepublic.model.Transacao;

import br.digitalRepublic.service.TransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

	private TransacaoService service;

	public TransacaoController(TransacaoService transacaoService) {
		this.service = service;
	}

	@PostMapping("/efetuar")
	private ResponseEntity transferir(@RequestBody Transacao transacao) throws DefaultException {
		service.transacionar(transacao);
		return ResponseEntity.ok().build();

	}

}
	
	
	
	
	
	


